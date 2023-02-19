plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.core.network"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    api(libs.bundles.network)
}
