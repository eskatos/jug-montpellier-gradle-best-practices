plugins {
    `kotlin-dsl`
}

group = "com.example"

repositories {
    gradlePluginPortal()
}

dependencies {

    compile("gradle.plugin.com.github.spotbugs:spotbugs-gradle-plugin:1.7.1")

    testImplementation("junit:junit:4.12")
    testImplementation(gradleTestKit())
}
