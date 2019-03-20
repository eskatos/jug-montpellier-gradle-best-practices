import com.github.spotbugs.SpotBugsExtension

plugins {
    base
    id("com.github.spotbugs") version "1.7.1" apply false
}

subprojects {

    apply(plugin = "java-base")
    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    repositories {
        jcenter()
    }

    apply(plugin = "com.github.spotbugs")
    configure<SpotBugsExtension> {
        toolVersion = "3.1.12"
        effort = "max"
        reportLevel = "low"
    }
}
