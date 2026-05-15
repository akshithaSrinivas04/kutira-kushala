package com.kutira.app.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val KutiraColors = lightColorScheme(
    primary = Terracotta,
    onPrimary = SurfaceWhite,
    primaryContainer = TerracottaLight,
    onPrimaryContainer = TerracottaDark,
    secondary = ForestGreen,
    onSecondary = SurfaceWhite,
    secondaryContainer = ForestGreenLight,
    onSecondaryContainer = ForestGreenDark,
    tertiary = ForestGreenDark,
    onTertiary = SurfaceWhite,
    background = Cream,
    onBackground = InkBlack,
    surface = SurfaceWhite,
    onSurface = InkBlack,
    surfaceVariant = Sand,
    onSurfaceVariant = InkDark,
    outline = InkOutline,
    outlineVariant = InkOutline
)

@Composable
fun KutiraTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Terracotta.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }
    MaterialTheme(
        colorScheme = KutiraColors,
        typography = KutiraTypography,
        content = content
    )
}
