package org.opticlab.android.compose.ui

import androidx.compose.Composable
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.material.MaterialTheme
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

private val DarkColorPalette = darkColorPalette(
        primary = colorSecondary,
        primaryVariant = colorSecondaryLight,
        secondary = colorPrimaryDark,
        onPrimary = colorOnSecondary,
        onSecondary = colorOnPrimary
)

private val LightColorPalette = lightColorPalette(
        primary = colorPrimary,
        primaryVariant = colorPrimaryDark,
        secondary = colorSecondary,
        onPrimary = colorOnPrimary,
        onSecondary = colorOnSecondary

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun KakaoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
    )
}