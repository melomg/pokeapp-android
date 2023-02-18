plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.core.network"

    buildFeatures {
        // Used to configure network logging
        buildConfig = true
    }
}

dependencies {
    api(libs.bundles.network)
}
