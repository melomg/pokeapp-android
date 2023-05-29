buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.detekt)
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        parallel = true
        buildUponDefaultConfig = true
        source.setFrom(getDetektSourcePaths())
        config.setFrom(files("${rootProject.projectDir}/detekt/detekt-config.yml"))
        ignoreFailures = false
    }
}

fun getDetektSourcePaths(): List<File> {
    val sourceDirs = mutableListOf<File>()
    subprojects.forEach {
        sourceDirs.add(file("${it.projectDir}/src/main/java"))
        sourceDirs.add(file("${it.projectDir}/src/test/java"))
        sourceDirs.add(file("${it.projectDir}/src/main/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/test/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/androidTest/java"))
    }
    return sourceDirs.filter { it.exists() }
}
