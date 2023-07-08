plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.favourites.impl"
}

dependencies {
    implementation(project(":features:favourites:api"))
}
