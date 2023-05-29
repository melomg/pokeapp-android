# Poke-app android [![Build Status](https://github.com/melomg/pokeapp-android/actions/workflows/PullRequest.yaml/badge.svg)](https://github.com/melomg/pokeapp-android/actions/workflows/PullRequest.yaml) [![Apache V2 License](https://img.shields.io/badge/License-Apache%20V2-blue)](LICENSE)

Playground app for [poke api](https://pokeapi.co/docs/graphql)

## Android Studio IDE setup

PokeApp is using Android Studio Dolphin | 2021.3.1 Patch 1 version

## Formatting

Project is using [detekt](https://github.com/detekt/detekt) for static code analysis. Please run
below command to format code before committing (pre-commit hook will be installed later)

## Tech Stack:

Demonstrates using Dagger 2.45+ in MVVM app with Android Architecture Components and Repository
pattern.

- MVVM
- Repository pattern
- Kotlin coroutines
- Jetpack Compose
- Jetpack Pagination
- Architecture Components
- Dagger2
- JUnit 5
- Retrofit

## Articles I've read and inspired when coding this playground app

For modular design:

- [Android at scale @Square](https://www.droidcon.com/2019/11/15/android-at-scale-square/)
- [Navigating through multi-module Jetpack Compose applications](https://proandroiddev.com/navigating-through-multi-module-jetpack-compose-applications-6c9a31fa12b6)
- [Modularising Trendyol Android App for Build Efficiency](https://medium.com/trendyol-tech/modularising-trendyol-android-app-for-build-efficiency-94f6b79fc012)
- [Herding Elephants](https://developer.squareup.com/blog/herding-elephants/)

For architecture:

- [Principles & Practice in Repository Layer](https://proandroiddev.com/principles-practice-in-repository-layer-444551b96cf8)

For testing:

- [The hidden cost of code coverage](https://jeroenmols.com/blog/2016/09/01/coveragecost/)
- [Don't mock static: test Timber Logger with trees](https://kotlintesting.com/test-timber/)

## Authors

* **[Melih Gultekin](https://github.com/melomg/)**

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
