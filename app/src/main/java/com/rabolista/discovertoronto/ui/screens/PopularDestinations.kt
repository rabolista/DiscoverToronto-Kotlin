package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.GTACities
import com.rabolista.discovertoronto.model.Destination
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.CityImageView
import com.rabolista.discovertoronto.ui.components.InlineNavigationBar
import com.rabolista.discovertoronto.ui.components.SectionHeader
import com.rabolista.discovertoronto.ui.components.asTile
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of PopularDestinationsView.swift (PopularDestinationsView, AllDestinationsView)

@Composable
fun PopularDestinationsSection(destinations: List<Destination> = GTACities.all) {
    val nav = LocalNavController.current
    Column {
        SectionHeader("Popular Destinations") { nav.navigate(Routes.ALL_DESTINATIONS) }
        Row(
            Modifier.horizontalScroll(rememberScrollState()).padding(start = 16.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            destinations.forEach { destination ->
                Column(
                    Modifier
                        .padding(bottom = 16.dp)
                        .asTile()
                        .plainClickable { nav.navigate(Routes.city(destination.name)) }
                ) {
                    CityImageView(
                        destination.imageName, destination.name,
                        Modifier.padding(6.dp).size(125.dp).clip(RoundedCornerShape(4.dp)),
                    )
                    Text(
                        destination.name, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                        color = Discover.colors.primaryText,
                        modifier = Modifier.padding(horizontal = 12.dp).width(113.dp),
                    )
                    Text(
                        destination.region, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp).width(113.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun AllDestinationsScreen(destinations: List<Destination>) {
    val nav = LocalNavController.current
    Column(Modifier.fillMaxSize().background(Discover.colors.discoverBackground)) {
        InlineNavigationBar(title = "GTA Cities", onBack = { nav.popBackStack() })
        val bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp + bottom),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(destinations) { destination ->
                Column(Modifier.asTile().plainClickable { nav.navigate(Routes.city(destination.name)) }) {
                    CityImageView(
                        destination.imageName, destination.name,
                        Modifier.padding(6.dp).fillMaxWidth().height(110.dp).clip(RoundedCornerShape(4.dp)),
                    )
                    Text(
                        destination.name, fontSize = 13.sp, fontWeight = FontWeight.SemiBold,
                        color = Discover.colors.primaryText, modifier = Modifier.padding(horizontal = 10.dp),
                    )
                    Text(
                        destination.region, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 8.dp),
                    )
                }
            }
        }
    }
}
