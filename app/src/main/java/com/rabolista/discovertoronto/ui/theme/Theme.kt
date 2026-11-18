package com.rabolista.discovertoronto.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/** iOS system colors used by the SwiftUI app (SwiftUI's .orange, .gray, .blue ...). */
object IOSColors {
    val orange = Color(0xFFFF9500)
    val red = Color(0xFFFF3B30)
    val green = Color(0xFF34C759)
    val teal = Color(0xFF30B0C7)
    val blue = Color(0xFF007AFF)
    val purple = Color(0xFFAF52DE)
    val pink = Color(0xFFFF2D55)
    val indigo = Color(0xFF5856D6)
    val cyan = Color(0xFF32ADE6)
    val gray = Color(0xFF8E8E93)
}

/** Semantic colors that change with light / dark mode (UIColor.systemBackground, etc.). */
@Immutable
data class DiscoverColors(
    val isDark: Boolean,
    /** UIColor.systemBackground — tiles / cards */
    val systemBackground: Color,
    /** UIColor.secondarySystemBackground — Color.discoverBackground */
    val discoverBackground: Color,
    /** Color.primary */
    val primaryText: Color,
    /** Header gradient in DiscoverView */
    val headerGradient: List<Color>,
    /** Search button fill over the header */
    val searchFieldFill: Color,
    /** UISearchBar / grouped list helpers */
    val searchBarFill: Color,
    val separator: Color,
)

val LightDiscoverColors = DiscoverColors(
    isDark = false,
    systemBackground = Color.White,
    discoverBackground = Color(0xFFF2F2F7),
    primaryText = Color.Black,
    headerGradient = listOf(Color(1.0f, 0.698f, 0.258f), Color(0.999f, 0.584f, 0.252f)),
    searchFieldFill = Color.White.copy(alpha = 0.3f),
    searchBarFill = Color(0x1F767680),
    separator = Color(0x4A3C3C43),
)

val DarkDiscoverColors = DiscoverColors(
    isDark = true,
    systemBackground = Color.Black,
    discoverBackground = Color(0xFF1C1C1E),
    primaryText = Color.White,
    headerGradient = listOf(Color(0.50f, 0.25f, 0.0f), Color(0.38f, 0.18f, 0.0f)),
    searchFieldFill = Color.Black.copy(alpha = 0.35f),
    searchBarFill = Color(0x3D767680),
    separator = Color(0x99545458),
)

val LocalDiscoverColors = staticCompositionLocalOf { LightDiscoverColors }

@Composable
fun DiscoverTorontoTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkDiscoverColors else LightDiscoverColors
    val scheme = if (darkTheme) {
        darkColorScheme(
            primary = IOSColors.orange,
            secondary = IOSColors.blue,
            background = colors.discoverBackground,
            surface = colors.systemBackground,
            onSurface = colors.primaryText,
            onBackground = colors.primaryText,
        )
    } else {
        lightColorScheme(
            primary = IOSColors.orange,
            secondary = IOSColors.blue,
            background = colors.discoverBackground,
            surface = colors.systemBackground,
            onSurface = colors.primaryText,
            onBackground = colors.primaryText,
        )
    }
    CompositionLocalProvider(LocalDiscoverColors provides colors) {
        MaterialTheme(colorScheme = scheme) {
            // SwiftUI Text has no extra letter spacing and uses the font's natural line height.
            ProvideTextStyle(TextStyle(color = colors.primaryText, letterSpacing = 0.sp), content = content)
        }
    }
}

object Discover {
    val colors: DiscoverColors
        @Composable get() = LocalDiscoverColors.current
}
