plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.pokemondetails.api"
}

dependencies {
    implementation(project(":core:navigation"))
}
