package com.rabolista.discovertoronto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rabolista.discovertoronto.ui.theme.Discover

/**
 * Port of TileModifier.swift / `.asTile()`:
 * systemBackground fill, 5pt corner radius, soft gray shadow (radius 4, y 2).
 */
fun Modifier.asTile(): Modifier = composed {
    val shape = RoundedCornerShape(5.dp)
    val shadowColor = Color(0.5f, 0.5f, 0.5f, 0.2f)
    this
        .shadow(elevation = 4.dp, shape = shape, ambientColor = shadowColor, spotColor = shadowColor.copy(alpha = 0.5f))
        .clip(shape)
        .background(Discover.colors.systemBackground)
}
