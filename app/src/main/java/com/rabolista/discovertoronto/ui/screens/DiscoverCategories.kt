package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.Catalog
import com.rabolista.discovertoronto.model.Category
import com.rabolista.discovertoronto.model.Place
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.InlineNavigationBar
import com.rabolista.discovertoronto.ui.components.SfSymbol
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of DiscoverCategoriesView.swift

object DiscoverCategories {
    val categories = listOf(
        Category(name = "Art", imageName = "paintpalette.fill"),
        Category(name = "Sport", imageName = "sportscourt.fill"),
        Category(name = "Live Events", imageName = "music.mic"),
        Category(name = "Food", imageName = "birthday.cake"),
        Category(name = "History", imageName = "books.vertical.fill"),
    )

    fun places(category: Category): List<Place> {
        val all = Catalog.allPlaces
        return when (category.name) {
            "Art" -> all.filter { it.category == "Arts & Culture" || it.systemImage == "paintpalette.fill" }
            "Sport" -> all.filter { it.category == "Recreation" || it.category == "Amusement Park" || it.systemImage.startsWith("figure.") }
            "Live Events" -> all.filter {
                it.category == "Arts & Culture" || it.systemImage == "music.mic" || it.systemImage == "theatermasks.fill" || it.systemImage == "sparkles"
            }
            "Food" -> all.filter { it.category == "Market" }
            "History" -> all.filter { it.category == "Historic Site" || (it.category == "Museum" && it.systemImage == "building.columns.fill") }
            else -> all
        }
    }
}

/** DiscoverCategoriesView — horizontal row of round category buttons on the orange header. */
@Composable
fun DiscoverCategoriesRow() {
    val nav = LocalNavController.current
    Row(
        Modifier.horizontalScroll(rememberScrollState()).padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.Top,
    ) {
        DiscoverCategories.categories.forEach { category ->
            Column(
                Modifier.width(68.dp).plainClickable { nav.navigate(Routes.category(category.name)) },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    Modifier.size(50.dp).clip(CircleShape).background(Discover.colors.systemBackground),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(SfSymbol.icon(category.imageName), null, tint = IOSColors.orange, modifier = Modifier.size(24.dp))
                }
                Text(
                    category.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
    }
}

/** CategoryDetailsView */
@Composable
fun CategoryDetailsScreen(category: Category) {
    val nav = LocalNavController.current
    val places = DiscoverCategories.places(category)
    Column(Modifier.fillMaxSize().background(Discover.colors.discoverBackground)) {
        InlineNavigationBar(title = category.name, onBack = { nav.popBackStack() })
        if (places.isEmpty()) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Icon(SfSymbol.icon(category.imageName), null, tint = IOSColors.orange.copy(alpha = 0.5f), modifier = Modifier.size(56.dp))
                Text("No places found for ${category.name} yet.", fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray)
            }
        } else {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                places.forEach { place ->
                    PlaceRowView(place) { nav.navigate(Routes.place(place.name)) }
                }
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
            }
        }
    }
}
