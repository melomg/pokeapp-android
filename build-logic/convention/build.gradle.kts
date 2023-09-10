plugins {
    `kotlin-dsl`
}

group = "com.melih.android.pokeapp.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "pokeapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCore") {
            id = "pokeapp.android.core"
            implementationClass = "AndroidCoreConventionPlugin"
        }
        register("androidFeatureLibrary") {
            id = "pokeapp.android.library.feature"
            implementationClass = "AndroidFeatureLibraryConventionPlugin"
        }
        register("androidKotlinLibrary") {
            id = "pokeapp.android.library.kotlin"
            implementationClass = "AndroidKotlinLibraryConventionPlugin"
        }
    }
}
