package my

import org.gradle.api.tasks.SourceSetContainer
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.GradleRunner
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

import withGeneratedProperties

import org.gradle.kotlin.dsl.*


class BuildLogicTest {

    @Rule
    @JvmField
    val tmpDir = TemporaryFolder()

    private
    val projectDir: File
        get() = tmpDir.root

    @Test
    fun `unit test`() {

        val project = ProjectBuilder.builder()
            .withProjectDir(projectDir)
            .build()

        project.run {
            apply(plugin = "java")

            withGeneratedProperties(
                the<SourceSetContainer>().named("main"),
                "foo",
                "bar",
                "bazar" to "cathedral"
            )
        }

        assertThat(project.tasks.names, hasItem("generatePropertiesFoo"))
    }

    @Test
    fun `integration test`() {

        projectDir.run {
            resolve("settings.gradle.kts").writeText("")
            resolve("build.gradle.kts").writeText("""
                plugins {
                    id("my.java-convention")
                    java
                }
            """.trimIndent())
            resolve("src/main/java/Source.java").apply {
                parentFile.mkdirs()
                writeText("""
                    interface Source {}
                """.trimIndent())
            }
        }

        val result = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(projectDir)
            .withArguments("check")
            .build()

        assertThat(result.output, containsString(":spotbugsMain"))
    }
}
