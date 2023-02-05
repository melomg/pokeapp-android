plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.favourites.implementation"
}

dependencies {
    implementation(project(":favourites:api"))
}
