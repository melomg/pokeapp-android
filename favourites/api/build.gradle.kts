plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.favourites.api"
}

dependencies {
    implementation(project(":favourites:implementation"))
    implementation(libs.bundles.navigation.core)
}
