plugins {
    id("pokeapp.android.application")
}

android {
    namespace = "com.melih.android.pokeapp"
    defaultConfig {
        applicationId = "com.melih.android.pokeapp"
        versionCode = 1
        versionName = "1.0.0"

        resValue("string", "app_name", "PokeApp")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "PokeApp Debug")
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
    implementation(project(":features:pokemons:impl-wiring"))
    implementation(project(":features:settings:impl-wiring"))
}
