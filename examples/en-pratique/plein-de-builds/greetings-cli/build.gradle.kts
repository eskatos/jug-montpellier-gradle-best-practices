plugins {
    java
    application
}

group = "com.example"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClassName = "greetings.cli.Main"
}

dependencies {
    implementation("com.example:greetings-impl:1.0")
}

val generatedResourcesDir = file("$buildDir/generated-resources/main")

val defaultSubjectProperties by tasks.registering(WriteProperties::class) {
    outputFile = file("$generatedResourcesDir/greetings/cli/default-subject.properties")
    property("subject", "Gradle World")
}

sourceSets.main {
    output.dir(
        generatedResourcesDir,
        "builtBy" to defaultSubjectProperties
    )
}
