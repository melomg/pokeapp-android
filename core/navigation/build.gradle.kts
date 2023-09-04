plugins {
    id("pokeapp.android.core")
}

android {
    namespace = "com.melih.android.pokeapp.core.navigation"
}

dependencies {
    api(libs.androidx.navigation.common.ktx)
    api(libs.androidx.navigation.runtime)
}
