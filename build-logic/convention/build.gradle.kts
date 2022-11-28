plugins {
    `kotlin-dsl`
}

group = "com.melih.android.swapp.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "swapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidFeatureLibrary") {
            id = "swapp.android.library.feature"
            implementationClass = "AndroidFeatureLibraryConventionPlugin"
        }
        register("androidKotlinLibrary") {
            id = "swapp.android.library.kotlin"
            implementationClass = "AndroidKotlinLibraryConventionPlugin"
        }
    }
}
