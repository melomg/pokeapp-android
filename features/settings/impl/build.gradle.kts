plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.settings.impl"
}

dependencies {
    implementation(project(":features:settings:api"))
}
