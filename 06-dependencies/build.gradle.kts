plugins {
  application
}

group = "com.acme.greeter"
version = "1.0"

defaultTasks("build")

repositories {
  mavenLocal()
}

dependencies {
  implementation("com.acme.greeter", "greeter-cli", "1.0")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
  }
}

application {
  mainClass.set("com.acme.GreeterFancy")
}

tasks.named<Jar>("jar") {
  manifest {
    attributes["Main-Class"] = application.mainClass.get()
  }
}
