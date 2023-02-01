pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PokeApp"

include(":app")
include(":core:designsystem")
include(":core:l10n")
include(":settings:api")
include(":settings:implementation")
include(":favourites:api")
include(":favourites:implementation")
