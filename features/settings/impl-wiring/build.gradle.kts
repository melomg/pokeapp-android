plugins {
    id("pokeapp.android.library.feature")
}

android {
    namespace = "com.melih.android.pokeapp.settings.impl.wiring"
}

dependencies {
    api(project(":features:settings:api"))
    implementation(project(":features:settings:impl"))
}
