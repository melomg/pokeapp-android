plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.impl.wiring"
}

dependencies {
    api(project(":features:pokemons:api"))
    implementation(project(":core:network"))
    implementation(project(":features:pokemons:impl"))
    implementation(libs.androidx.paging.common)
}
