rootProject.name = "greetings-impl"

includeBuild("../build-logic")
includeBuild("../greetings-api")

gradle.rootProject {
    buildscript {
        dependencies {
            classpath("com.example:build-logic:1.0")
        }
    }
}
