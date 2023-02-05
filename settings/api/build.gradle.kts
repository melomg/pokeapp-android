plugins {
    id("pokeapp.android.library.kotlin")
}

android {
    namespace = "com.melih.android.pokeapp.settings.api"
}

dependencies {
    implementation(project(":core:navigation"))
}
