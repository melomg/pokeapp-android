plugins {
    id("pokeapp.android.core")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.melih.android.pokeapp.core.designsystem"
}

dependencies {
    implementation(libs.google.accompanist.systemuicontroller)
}
