import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.melih.apps.pokeapp.SdkVersions
import com.melih.apps.pokeapp.configureAndroidFeature
import com.melih.apps.pokeapp.configureJacoco
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
                apply("org.gradle.jacoco")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidFeature(this)
                defaultConfig.targetSdk = SdkVersions.targetSdkVersion
            }

            extensions.configure<ApplicationAndroidComponentsExtension> {
                configureJacoco(this)
            }
        }
    }
}
