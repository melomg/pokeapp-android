plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.impl"
}

dependencies {
    implementation(project(":pokemons:api"))
}