plugins {
    id("pokeapp.android.application")
}

android {
    namespace = "com.melih.android.pokeapp"
    defaultConfig {
        applicationId = "com.melih.android.pokeapp"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
        }
        val release by getting {
            isMinifyEnabled = true
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(project(":favourites:impl-wiring"))
    implementation(project(":pokemons:impl-wiring"))
    implementation(project(":settings:impl-wiring"))
}
