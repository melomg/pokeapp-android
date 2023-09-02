plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemondetails.impl.wiring"
}

dependencies {
    api(project(":features:pokemondetails:api"))
    implementation(project(":features:pokemondetails:impl"))
}
