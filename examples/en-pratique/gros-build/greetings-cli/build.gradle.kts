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
