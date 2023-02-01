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
// Core
include(":core:designsystem")
include(":core:l10n")
// Features
include(":favourites:api")
include(":favourites:implementation")
include(":pokemons:api")
include(":pokemons:implementation")
include(":settings:api")
include(":settings:implementation")
