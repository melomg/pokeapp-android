plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.impl.wiring"
}

dependencies {
    api(project(":pokemons:api"))
    implementation(project(":pokemons:impl"))
}
