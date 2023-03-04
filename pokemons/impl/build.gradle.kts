plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.impl"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:result-ext"))
    implementation(project(":pokemons:api"))
}
