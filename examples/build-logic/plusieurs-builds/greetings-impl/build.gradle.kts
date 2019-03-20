plugins {
    id("my.java-convention")
    `java-library`
}

group = "com.example"

dependencies {

    api("com.example:greetings-api:1.0")

    testImplementation("junit:junit:4.12")
}

repositories {
    jcenter()
}
