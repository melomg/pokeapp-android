package com.melih.apps.pokeapp

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

internal fun Project.configureAndroidFeature(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    configureAndroidKotlin(commonExtension)

    configureAndroidCompose(commonExtension)

    dependencies {
        val androidx = libs.findBundle("androidx").get()
        val androidxTest = libs.findBundle("android-test").get()

        add("implementation", project(":core:designsystem"))
        add("implementation", androidx)

        add("androidTestImplementation", androidxTest)
        add("androidTestImplementation", kotlin("test"))
    }
}
