plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.api"
}

dependencies {
    implementation(project(":pokemons:implementation"))
    implementation(libs.bundles.navigation.core)
}
