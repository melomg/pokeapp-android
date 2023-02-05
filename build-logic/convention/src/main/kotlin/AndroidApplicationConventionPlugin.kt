import com.android.build.api.dsl.ApplicationExtension
import com.melih.apps.pokeapp.SdkVersions
import com.melih.apps.pokeapp.configureAndroidFeature
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("dagger.hilt.android.plugin")
                apply("kotlin-kapt")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidFeature(this)
                defaultConfig.targetSdk = SdkVersions.targetSdkVersion
            }
        }
    }
}
