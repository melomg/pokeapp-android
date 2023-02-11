plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.favourites.impl.wiring"
}

dependencies {
    api(project(":favourites:api"))
    implementation(project(":favourites:impl"))
}
