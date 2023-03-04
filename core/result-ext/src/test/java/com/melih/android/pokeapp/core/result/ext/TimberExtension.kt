package com.melih.android.pokeapp.core.result.ext

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import timber.log.Timber

internal class TimberExtension : BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private val timber = TestTimber()

    override fun beforeEach(context: ExtensionContext) {
        Timber.plant(timber)
    }

    override fun afterEach(context: ExtensionContext) {
        Timber.uprootAll()
    }

    override fun supportsParameter(
        parameterContext: ParameterContext?,
        extensionContext: ExtensionContext?,
    ): Boolean {
        return parameterContext?.parameter?.type?.equals(TestTimber::class.java) == true
    }

    override fun resolveParameter(
        parameterContext: ParameterContext?,
        extensionContext: ExtensionContext?,
    ): TestTimber = timber
}
