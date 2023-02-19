package com.melih.android.pokeapp.core.coroutines.test

import com.melih.android.pokeapp.core.coroutines.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class TestDispatcherExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext) {
        val testDispatcher = StandardTestDispatcher()
        DispatcherProvider.testingOverride = testDispatcher
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterEach(context: ExtensionContext) {
        Dispatchers.resetMain()
    }
}
