package com.melih.android.pokeapp.core.result.ext

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExtendWith(TimberExtension::class)
internal class ResultExtensionsTest {

    @Nested
    inner class LogErrorTest {

        @Test
        fun `when result is success, then error is NOT logged`(timber: TestTimber) {
            Result.success("Success!").alsoLogError()

            assertTrue { timber.logs.isEmpty() }
        }

        @Test
        fun `when result is failure, then error is logged`(timber: TestTimber) {
            val exception = IllegalStateException()

            Result.failure<Any>(exception).alsoLogError()

            assertTrue { timber.logs.size == 1 }
            assertEquals(
                expected = exception,
                actual = timber.logs.last().t,
            )
        }
    }
}
