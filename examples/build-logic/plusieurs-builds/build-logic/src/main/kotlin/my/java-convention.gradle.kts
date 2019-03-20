package my

plugins {
    `java-base`
    id("com.github.spotbugs")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter()
}

spotbugs {
    toolVersion = "3.1.12"
    effort = "max"
    reportLevel = "low"
}
