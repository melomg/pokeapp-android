import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }

    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
