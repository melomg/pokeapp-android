plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.settings.api"
}

dependencies {
    implementation(project(":settings:implementation"))
    implementation(libs.bundles.navigation.core)
}
