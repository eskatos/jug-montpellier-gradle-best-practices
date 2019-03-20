import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.WriteProperties
import org.gradle.kotlin.dsl.*


fun Project.withGeneratedProperties(
    sourceSet: NamedDomainObjectProvider<SourceSet>,
    name: String,
    path: String,
    vararg properties: Pair<String, Any>
) {
    val generatedResourcesDir = file("$buildDir/generated-resources/$name")

    val task = tasks.register<WriteProperties>("generateProperties${name.capitalize()}") {
        outputFile = file("$generatedResourcesDir/$path/$name.properties")
        properties.forEach { (name, value) ->
            property(name, value)
        }
    }

    sourceSet {
        output.dir(generatedResourcesDir, "builtBy" to task)
    }
}
