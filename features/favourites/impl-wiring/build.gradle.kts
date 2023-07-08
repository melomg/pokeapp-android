plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.favourites.impl.wiring"
}

dependencies {
    api(project(":features:favourites:api"))
    implementation(project(":features:favourites:impl"))
}
