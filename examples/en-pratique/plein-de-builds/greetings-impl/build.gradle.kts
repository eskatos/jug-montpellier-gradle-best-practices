plugins {
    `java-library`
}

group = "com.example"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    api("com.example:greetings-api:1.0")

    testImplementation("junit:junit:4.12")
}

repositories {
    jcenter()
}
