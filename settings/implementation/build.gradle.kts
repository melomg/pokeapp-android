plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.settings.implementation"
}

dependencies {
    implementation(project(":settings:api"))
}
