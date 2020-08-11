package org.opticlab.android.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColors = darkColors(
        primary = colorSecondary,
        primaryVariant = colorSecondaryLight,
        secondary = colorPrimaryDark,
        onPrimary = colorOnSecondary,
        onSecondary = colorOnPrimary
)

private val LightColors = lightColors(
        primary = colorPrimary,
        primaryVariant = colorPrimaryDark,
        secondary = colorSecondary,
        secondaryVariant = colorSecondaryDark,
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
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
    )
}