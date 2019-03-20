plugins {
    `java-library`
}

dependencies {

    api(project(":greetings-api"))

    testImplementation("junit:junit:4.12")
}
