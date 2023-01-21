import com.android.build.api.dsl.ApplicationExtension
import com.melih.apps.pokeapp.SdkVersions
import com.melih.apps.pokeapp.configureAndroidFeature
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidFeature(this)
                defaultConfig.targetSdk = SdkVersions.targetSdkVersion
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
            }
        }
    }
}
