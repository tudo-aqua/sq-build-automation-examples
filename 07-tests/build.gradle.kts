import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  application
  `maven-publish`
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
