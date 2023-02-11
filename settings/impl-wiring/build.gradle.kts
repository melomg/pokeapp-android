plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.settings.impl.wiring"
}

dependencies {
    api(project(":settings:api"))
    implementation(project(":settings:impl"))
}
