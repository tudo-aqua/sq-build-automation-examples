import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  application
  `maven-publish`
  id("com.diffplug.spotless") version "6.25.0"
}

group = "com.acme.greeter"
version = "1.0"

defaultTasks("build")

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.11.3"))
  testImplementation("org.junit.jupiter", "junit-jupiter")
  testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
}

spotless {
  java {
    importOrder()
    googleJavaFormat()
  }
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
  }
  withSourcesJar()
  withJavadocJar()
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    events(FAILED, PASSED, SKIPPED)
  }
}

application {
  mainClass.set("com.acme.GreeterCLI")
}

tasks.named<Jar>("jar") {
  manifest {
    attributes["Main-Class"] = application.mainClass.get()
  }
}

publishing {
  publications {
    create<MavenPublication>("greeterCLI") {
      from(components["java"])
    }
  }
}

val env = System.getenv()

if (env["CI"] == "true") {
  publishing {
    repositories {
      maven {
        name = "GitLab"
        url = uri("${env.getValue("CI_API_V4_URL")}/projects/${env.getValue("CI_PROJECT_ID")}/packages/maven")
        credentials(HttpHeaderCredentials::class) {
          name = "Job-Token"
          value = env.getValue("CI_JOB_TOKEN")
        }
        authentication {
          create<HttpHeaderAuthentication>("header")
        }
      }
    }
  }
}
