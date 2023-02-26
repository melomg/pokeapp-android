package com.melih.apps.pokeapp

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.gradle.testing.jacoco.tasks.JacocoReportBase

private val coverageExclusions = listOf(
    // Android
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/build/*"
)

/**
 * Modified from: https://github.com/android/nowinandroid
 */
internal fun Project.configureJacoco(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    configure<JacocoPluginExtension> {
        toolVersion = libs.findVersion("jacoco").get().toString()
    }

    val jacocoTestReport = tasks.create("jacocoTestReport")
    val minimumCoverage = "0.4".toBigDecimal() // fixme increase this to 0.8 when ui tests are added

    val debug = androidComponentsExtension.selector().withBuildType("debug")
    androidComponentsExtension.onVariants(debug) { variant ->
        val testTaskName = "test${variant.name.capitalize()}UnitTest"

        val reportTask = tasks.register(
            name = "jacoco${testTaskName.capitalize()}Report",
            type = JacocoReport::class
        ) {
            group = "Verification"
            description = "Generate JaCoCo coverage report for the debug unit tests."
            dependsOn(testTaskName)

            reports {
                xml.required.set(true)
                html.required.set(true)
            }

            setDirectories(variant.name, testTaskName)
        }

        jacocoTestReport.dependsOn(reportTask)
    }

    tasks.register(
        name = "jacocoCoverageVerification",
        type = JacocoCoverageVerification::class
    ) {
        group = "Verification"
        description = "Code coverage report"
        dependsOn(jacocoTestReport)

        violationRules {
            rule {
                limit {
                    minimum = minimumCoverage
                }
            }
            rule {
                element = "CLASS"
                excludes = listOf(
                    "**.Companion",
                    "**.*ScreenKt",
                    "**.*Router",
                )
                limit {
                    minimum = minimumCoverage
                }
            }
        }

        setDirectories("debug", "testDebugUnitTest")
    }

    tasks.withType<Test>().configureEach {
        finalizedBy(jacocoTestReport) // report is always generated after tests run

        configure<JacocoTaskExtension> {
            // Required for JDK 11 with the above
            // https://github.com/gradle/gradle/issues/5184#issuecomment-391982009
            excludes = listOf("jdk.internal.*")
        }
    }
}

private fun JacocoReportBase.setDirectories(
    variantName: String,
    testTaskName: String,
) {
    classDirectories.setFrom(
        project.fileTree("${project.buildDir}/tmp/kotlin-classes/$variantName") {
            exclude(coverageExclusions)
        }
    )
    sourceDirectories.setFrom(
        project.files(
            "${project.projectDir}/src/main/java",
            "${project.projectDir}/src/main/kotlin"
        )
    )
    executionData.setFrom(project.file("${project.buildDir}/jacoco/$testTaskName.exec"))
}
