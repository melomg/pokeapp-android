@file:Suppress("UnstableApiUsage")

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
include(":core:coroutines")
include(":core:designsystem")
include(":core:l10n")
include(":core:navigation")
include(":core:network")
// Features
include(":favourites:api")
include(":favourites:impl")
include(":favourites:impl-wiring")
include(":pokemons:api")
include(":pokemons:impl")
include(":pokemons:impl-wiring")
include(":settings:api")
include(":settings:impl")
include(":settings:impl-wiring")
