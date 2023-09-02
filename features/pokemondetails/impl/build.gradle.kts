plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemondetails.impl"
}

dependencies {
    implementation(project(":features:pokemondetails:api"))
}
