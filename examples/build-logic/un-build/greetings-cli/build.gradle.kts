plugins {
    java
    application
}

application {
    mainClassName = "greetings.cli.Main"
}

dependencies {
    implementation(project(":greetings-impl"))
}

withGeneratedProperties(
    sourceSets.main,
    "default-subject",
    "greetings/cli",
    "subject" to "Gradle World"
)
