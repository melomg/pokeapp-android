package com.melih.android.pokeapp.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.jetbrains.annotations.TestOnly

/**
 * Provider of kotlinx.coroutines.Dispatchers to help testing.
 *
 * Temporary workaround to make [Dispatchers] testable, until this
 * [issue](https://github.com/Kotlin/kotlinx.coroutines/issues/1365) has been resolved.
 */
@Suppress("unused")
object DispatcherProvider {

    @set:TestOnly
    var testingOverride: CoroutineDispatcher? = null

    val Main
        get() = Dispatchers.Main

    val Default: CoroutineDispatcher
        get() = testingOverride ?: Dispatchers.Default

    val IO: CoroutineDispatcher
        get() = testingOverride ?: Dispatchers.IO
}
