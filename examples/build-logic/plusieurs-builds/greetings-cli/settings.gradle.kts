rootProject.name = "greetings-cli"

includeBuild("../build-logic")
includeBuild("../greetings-impl")
includeBuild("../greetings-api")

gradle.rootProject {
    buildscript {
        dependencies {
            classpath("com.example:build-logic:1.0")
        }
    }
}
