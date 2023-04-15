# Poke-app android [![Build Status](https://github.com/melomg/pokeapp-android/actions/workflows/PullRequest.yaml/badge.svg)](https://github.com/melomg/pokeapp-android/actions/workflows/PullRequest.yaml) [![Apache V2 License](https://img.shields.io/badge/License-Apache%20V2-blue)](LICENSE)

Playground app for [poke api](https://pokeapi.co/docs/graphql)

## Android Studio IDE setup

PokeApp is using Android Studio Dolphin | 2021.3.1 Patch 1 version

## Formatting

Project is using [spotless](https://github.com/diffplug/spotless) to format and check code style. 
Please run below command to format code before committing (pre-commit hook will be installed later)

`./gradlew --init-script gradle/init.gradle.kts spotlessApply --no-configuration-cache`

## Authors

* **[Melih Gultekin](https://github.com/melomg/)**

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
