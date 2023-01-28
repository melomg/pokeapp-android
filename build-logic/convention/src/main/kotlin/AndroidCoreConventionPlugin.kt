import com.android.build.gradle.LibraryExtension
import com.melih.apps.pokeapp.SdkVersions
import com.melih.apps.pokeapp.configureAndroidCompose
import com.melih.apps.pokeapp.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidCoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {

                configureAndroidKotlin(this)

                configureAndroidCompose(this)

                defaultConfig.targetSdk = SdkVersions.targetSdkVersion
            }
        }
    }
}
