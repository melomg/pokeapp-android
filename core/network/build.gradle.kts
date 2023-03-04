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
    implementation(libs.dagger.hilt.android)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.noop)
}
