package com.rabolista.discovertoronto.ui.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.rabolista.discovertoronto.data.ImageAssets
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of Utils/PlaceholderImageViews.swift

private fun picsumUrl(seed: String) = "https://picsum.photos/seed/${Uri.encode(seed)}/600/400"

/**
 * Bundled drawable if one exists for [imageName], otherwise a remote picsum photo seeded by the name,
 * otherwise [fallback]. Always scaled to fill (ContentScale.Crop == .scaledToFill()).
 */
@Composable
private fun AssetOrRemoteImage(
    imageName: String,
    modifier: Modifier,
    remoteUrl: String?,
    fallback: @Composable () -> Unit,
) {
    val res = ImageAssets.drawable(imageName)
    val model: Any? = res ?: remoteUrl
    if (model == null) {
        Box(modifier) { fallback() }
        return
    }
    SubcomposeAsyncImage(
        model = model,
        contentDescription = imageName,
        contentScale = ContentScale.Crop,
        modifier = modifier,
        loading = { fallback() },
        error = { fallback() },
    )
}

/** Rectangular tile for destination/city cards (CityImageView). */
@Composable
fun CityImageView(imageName: String, cityName: String, modifier: Modifier = Modifier) {
    AssetOrRemoteImage(
        imageName = imageName,
        modifier = modifier,
        remoteUrl = if (imageName.isNotEmpty()) picsumUrl(imageName) else null,
    ) {
        val theme = CityTheme.theme(cityName)
        Box(
            Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(theme.colors)),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(SfSymbol.icon(theme.systemImage), null, tint = Color.White, modifier = Modifier.size(28.dp))
                Text(
                    cityName,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp),
                )
            }
        }
    }
}

private data class CityTheme(val systemImage: String, val colors: List<Color>) {
    companion object {
        fun theme(cityName: String): CityTheme = when (cityName) {
            "Mississauga" -> CityTheme("building.2.crop.circle.fill", listOf(IOSColors.purple, IOSColors.pink))
            "Brampton" -> CityTheme("leaf.fill", listOf(IOSColors.green, IOSColors.teal))
            "Vaughan" -> CityTheme("star.fill", listOf(IOSColors.blue, IOSColors.purple))
            "Markham" -> CityTheme("building.columns.fill", listOf(IOSColors.teal, IOSColors.blue))
            "Richmond Hill" -> CityTheme("sparkles", listOf(IOSColors.indigo, Color.Black))
            "Oakville" -> CityTheme("sailboat.fill", listOf(IOSColors.blue, IOSColors.cyan))
            "Burlington" -> CityTheme("leaf.arrow.circlepath", listOf(IOSColors.green, IOSColors.cyan))
            "Ajax" -> CityTheme("beach.umbrella.fill", listOf(IOSColors.cyan, IOSColors.blue))
            "Oshawa" -> CityTheme("car.fill", listOf(IOSColors.gray, IOSColors.red))
            else -> CityTheme("building.2.fill", listOf(IOSColors.orange, IOSColors.red))
        }
    }
}

/** Rectangular tile for attraction rows/detail screens (PlaceImageView). */
@Composable
fun PlaceImageView(imageName: String, systemImage: String, modifier: Modifier = Modifier, iconSize: Int = 24) {
    AssetOrRemoteImage(
        imageName = imageName,
        modifier = modifier,
        remoteUrl = if (imageName.isNotEmpty()) picsumUrl(imageName) else null,
    ) {
        Box(Modifier.fillMaxSize().background(IOSColors.orange), contentAlignment = Alignment.Center) {
            Icon(SfSymbol.icon(systemImage), null, tint = Color.White, modifier = Modifier.size(iconSize.dp))
        }
    }
}

/** Circular avatar for creator profiles: DiceBear illustrated avatars, falls back to initials. */
@Composable
fun AvatarImageView(imageName: String, name: String, modifier: Modifier = Modifier) {
    val url = "https://api.dicebear.com/9.x/avataaars/png?seed=${Uri.encode(name)}&size=200"
    AssetOrRemoteImage(imageName = imageName, modifier = modifier.clip(CircleShape), remoteUrl = url) {
        Box(
            Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(Brush.verticalGradient(avatarColors(name))),
            contentAlignment = Alignment.Center,
        ) {
            Text(initials(name), fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

/** Each creator gets a unique, consistent color pair derived from their name. */
private fun avatarColors(name: String): List<Color> {
    val palettes = listOf(
        listOf(IOSColors.orange, IOSColors.red),
        listOf(IOSColors.blue, IOSColors.purple),
        listOf(IOSColors.green, IOSColors.teal),
        listOf(IOSColors.purple, IOSColors.pink),
        listOf(IOSColors.teal, IOSColors.cyan),
        listOf(Color(0.9f, 0.2f, 0.4f), IOSColors.orange),
    )
    return palettes[Math.floorMod(name.hashCode(), palettes.size)]
}

private fun initials(name: String): String =
    name.split(" ").filter { it.isNotEmpty() }.take(2).map { it.first().toString() }.joinToString("").uppercase()
