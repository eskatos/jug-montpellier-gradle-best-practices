rootProject.name = "greetings-api"

includeBuild("../build-logic")

gradle.rootProject {
    buildscript {
        dependencies {
            classpath("com.example:build-logic:1.0")
        }
    }
}
