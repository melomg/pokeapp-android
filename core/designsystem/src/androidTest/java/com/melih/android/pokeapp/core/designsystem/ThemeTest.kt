package com.melih.android.pokeapp.core.designsystem

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import com.melih.android.pokeapp.core.designsystem.theme.DarkColorScheme
import com.melih.android.pokeapp.core.designsystem.theme.LightColorScheme
import com.melih.android.pokeapp.core.designsystem.theme.PokeAppTheme
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun darkThemeFalse_dynamicColorFalse() {
        composeTestRule.setContent {
            PokeAppTheme(
                darkTheme = false,
                dynamicColor = false,
            ) {
                assertColorSchemesEqual(LightColorScheme, MaterialTheme.colorScheme)
            }
        }
    }

    @Test
    fun darkThemeTrue_dynamicColorFalse() {
        composeTestRule.setContent {
            PokeAppTheme(
                darkTheme = true,
                dynamicColor = false,
            ) {
                assertColorSchemesEqual(DarkColorScheme, MaterialTheme.colorScheme)
            }
        }
    }

    @Test
    fun darkThemeFalse_dynamicColorTrue() {
        composeTestRule.setContent {
            PokeAppTheme(
                darkTheme = false,
            ) {
                val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    dynamicLightColorScheme(LocalContext.current)
                } else {
                    LightColorScheme
                }

                assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)
            }
        }
    }

    @Test
    fun darkThemeTrue_dynamicColorTrue() {
        composeTestRule.setContent {
            PokeAppTheme(
                darkTheme = true,
            ) {
                val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    dynamicDarkColorScheme(LocalContext.current)
                } else {
                    DarkColorScheme
                }

                assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)
            }
        }
    }

    /**
     * Workaround for the fact that the NiA design system specify all color scheme values.
     */
    private fun assertColorSchemesEqual(
        expectedColorScheme: ColorScheme,
        actualColorScheme: ColorScheme,
    ) {
        assertEquals(expectedColorScheme.primary, actualColorScheme.primary)
        assertEquals(expectedColorScheme.onPrimary, actualColorScheme.onPrimary)
        assertEquals(expectedColorScheme.primaryContainer, actualColorScheme.primaryContainer)
        assertEquals(expectedColorScheme.onPrimaryContainer, actualColorScheme.onPrimaryContainer)
        assertEquals(expectedColorScheme.secondary, actualColorScheme.secondary)
        assertEquals(expectedColorScheme.onSecondary, actualColorScheme.onSecondary)
        assertEquals(expectedColorScheme.secondaryContainer, actualColorScheme.secondaryContainer)
        assertEquals(
            expectedColorScheme.onSecondaryContainer,
            actualColorScheme.onSecondaryContainer,
        )
        assertEquals(expectedColorScheme.tertiary, actualColorScheme.tertiary)
        assertEquals(expectedColorScheme.onTertiary, actualColorScheme.onTertiary)
        assertEquals(expectedColorScheme.tertiaryContainer, actualColorScheme.tertiaryContainer)
        assertEquals(expectedColorScheme.onTertiaryContainer, actualColorScheme.onTertiaryContainer)
        assertEquals(expectedColorScheme.background, actualColorScheme.background)
        assertEquals(expectedColorScheme.onBackground, actualColorScheme.onBackground)
        assertEquals(expectedColorScheme.surface, actualColorScheme.surface)
        assertEquals(expectedColorScheme.onSurface, actualColorScheme.onSurface)
        assertEquals(expectedColorScheme.surfaceVariant, actualColorScheme.surfaceVariant)
        assertEquals(expectedColorScheme.onSurfaceVariant, actualColorScheme.onSurfaceVariant)
        assertEquals(expectedColorScheme.error, actualColorScheme.error)
        assertEquals(expectedColorScheme.onError, actualColorScheme.onError)
        assertEquals(expectedColorScheme.errorContainer, actualColorScheme.errorContainer)
        assertEquals(expectedColorScheme.onErrorContainer, actualColorScheme.onErrorContainer)
        assertEquals(expectedColorScheme.outline, actualColorScheme.outline)
    }
}
