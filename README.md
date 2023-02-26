# Poke-app android 
Playground app for [poke api](https://pokeapi.co/docs/graphql)

## Formatting
Project is using [spotless](https://github.com/diffplug/spotless) to format and check code style. 
Please run below command to format code before committing (pre-commit hook will be installed later)

`./gradlew --init-script gradle/init.gradle.kts spotlessApply`
