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
include(":core:coroutines-test")
include(":core:designsystem")
include(":core:l10n")
include(":core:navigation")
include(":core:network")
include(":core:result-ext")
// Features
include(":features:favourites:api")
include(":features:favourites:impl")
include(":features:favourites:impl-wiring")

include(":features:pokemons:api")
include(":features:pokemons:impl")
include(":features:pokemons:impl-wiring")

include(":features:pokemondetails:api")
include(":features:pokemondetails:impl")
include(":features:pokemondetails:impl-wiring")

include(":features:settings:api")
include(":features:settings:impl")
include(":features:settings:impl-wiring")
