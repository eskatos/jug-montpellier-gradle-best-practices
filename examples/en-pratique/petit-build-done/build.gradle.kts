plugins {
    base
}

base {
    archivesBaseName = "mon-petit-build"
}

println("configuration")

tasks {
    build {
        println("configuration aussi")
        doLast {
            println("execution")
        }
    }
}

tasks {
    val genProps by registering(WriteProperties::class) {
        outputFile = file("$buildDir/gen/my.properties")
        property("foo", "bar")
        // property("bad", java.util.UUID.randomUUID())
    }
    assemble {
        dependsOn(genProps)
    }
}

