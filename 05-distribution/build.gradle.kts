plugins {
  application
  `maven-publish`
}

group = "com.acme.greeter"
version = "1.0"

defaultTasks("build")

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
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
