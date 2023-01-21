plugins {
    id("pokeapp.android.library.feature")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.melih.android.pokeapp.core.designsystem"
}
