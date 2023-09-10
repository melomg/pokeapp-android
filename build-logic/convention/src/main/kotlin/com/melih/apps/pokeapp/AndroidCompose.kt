package com.melih.apps.pokeapp

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val androidx = libs.findBundle("androidx").get()
            val androidxTest = libs.findBundle("android-test").get()
            val bom = libs.findLibrary("androidx-compose-bom").get()
            val composeBundle = libs.findBundle("compose").get()
            val composeUITest = libs.findLibrary("androidx-compose-ui-test").get()
            val composeUIManifest = libs.findLibrary("androidx-compose-ui-manifest").get()
            val composeUITooling = libs.findLibrary("androidx-compose-ui-tooling").get()
            val kotlinxCollectionsImmutable =
                libs.findLibrary("kotlinx-collections-immutable").get()

            add("implementation", androidx)
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("androidTestImplementation", composeUITest)

            add("implementation", composeBundle)
            add("debugImplementation", composeUIManifest)
            add("debugImplementation", composeUITooling)

            add("implementation", kotlinxCollectionsImmutable)

            add("androidTestImplementation", androidxTest)
            add("androidTestImplementation", kotlin("test"))
        }
    }
}
