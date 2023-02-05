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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(":favourites:api"))
    implementation(project(":favourites:implementation"))
    implementation(project(":pokemons:api"))
    implementation(project(":pokemons:impl"))
    implementation(project(":settings:api"))
    implementation(project(":settings:implementation"))
}
