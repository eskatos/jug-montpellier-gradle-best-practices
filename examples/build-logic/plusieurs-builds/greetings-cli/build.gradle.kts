plugins {
    id("my.java-convention")
    java
    application
}

group = "com.example"

application {
    mainClassName = "greetings.cli.Main"
}

dependencies {
    implementation("com.example:greetings-impl:1.0")
}

withGeneratedProperties(
    sourceSets.main,
    "default-subject",
    "greetings/cli",
    "subject" to "Gradle World"
)
