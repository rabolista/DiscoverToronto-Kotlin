package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.GTARestaurants
import com.rabolista.discovertoronto.model.Restaurant
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.Chevron
import com.rabolista.discovertoronto.ui.components.DirectionsButton
import com.rabolista.discovertoronto.ui.components.PlaceImageView
import com.rabolista.discovertoronto.ui.components.SectionHeader
import com.rabolista.discovertoronto.ui.components.SfSymbol
import com.rabolista.discovertoronto.ui.components.asTile
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of PopularRestaurantsView.swift (PopularRestaurantsView, AllRestaurantsView, RestaurantDetailView)
// Note: like the iOS app, restaurant photos use the restaurant name as the image name (remote seeded photo).

@Composable
fun PopularRestaurantsSection(restaurants: List<Restaurant> = GTARestaurants.top30.take(6)) {
    val nav = LocalNavController.current
    Column {
        SectionHeader("Popular Places to Eat") { nav.navigate(Routes.ALL_RESTAURANTS) }
        Row(
            Modifier.horizontalScroll(rememberScrollState()).padding(start = 16.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            restaurants.forEach { restaurant ->
                Row(
                    Modifier
                        .padding(bottom = 16.dp)
                        .width(240.dp)
                        .asTile()
                        .plainClickable { nav.navigate(Routes.restaurant(restaurant.name)) },
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    PlaceImageView(
                        restaurant.name, restaurant.systemImage,
                        Modifier.padding(start = 6.dp, top = 6.dp, bottom = 6.dp).size(60.dp).clip(RoundedCornerShape(8.dp)),
                    )
                    Column(Modifier.weight(1f).padding(end = 6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(restaurant.name, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(SfSymbol.icon("star.fill"), null, tint = IOSColors.orange, modifier = Modifier.size(14.dp))
                            Text(restaurant.summary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                        }
                        Text(restaurant.city, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray)
                    }
                }
            }
        }
    }
}

@Composable
fun AllRestaurantsScreen(restaurants: List<Restaurant>) {
    val nav = LocalNavController.current
    DetailScaffold(title = "Top 30 GTA Restaurants") {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            restaurants.forEach { restaurant ->
                Row(
                    Modifier.fillMaxWidth().asTile().plainClickable { nav.navigate(Routes.restaurant(restaurant.name)) }.padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    PlaceImageView(restaurant.name, restaurant.systemImage, Modifier.size(48.dp).clip(CircleShape), iconSize = 20)
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(restaurant.name, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Icon(SfSymbol.icon("star.fill"), null, tint = IOSColors.orange, modifier = Modifier.size(11.dp))
                            Text(restaurant.summary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray)
                        }
                        Text(restaurant.city, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
                    }
                    Chevron()
                }
            }
        }
    }
}

@Composable
fun RestaurantDetailScreen(restaurant: Restaurant) {
    DetailScaffold {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            PlaceImageView(restaurant.name, restaurant.systemImage, Modifier.fillMaxWidth().height(220.dp))
            Column(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(restaurant.name, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Discover.colors.primaryText)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(SfSymbol.icon("star.fill"), null, tint = IOSColors.orange, modifier = Modifier.size(17.dp))
                    Text(restaurant.summary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                }
                Text(restaurant.city, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
                Text(restaurant.details, fontSize = 15.sp, color = IOSColors.gray, lineHeight = 22.sp)
                if (restaurant.address.isNotEmpty()) {
                    DirectionsButton(restaurant.name, restaurant.address)
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
