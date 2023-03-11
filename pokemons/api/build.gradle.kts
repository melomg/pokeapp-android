plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.pokemons.api"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(libs.androidx.paging.common)
}
