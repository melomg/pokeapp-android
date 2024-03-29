plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.impl"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:result-ext"))
    implementation(project(":features:pokemons:api"))
    implementation(project(":features:pokemondetails:api"))
    implementation(libs.bundles.paging)
    implementation(libs.coil.compose)

    testImplementation(libs.androidx.paging.common)
    testImplementation(libs.androidx.test.paging)
}
