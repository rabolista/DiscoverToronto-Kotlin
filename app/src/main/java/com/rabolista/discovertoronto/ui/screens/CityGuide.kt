package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.CityGuideData
import com.rabolista.discovertoronto.model.Destination
import com.rabolista.discovertoronto.model.Place
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.Chevron
import com.rabolista.discovertoronto.ui.components.CityImageView
import com.rabolista.discovertoronto.ui.components.DirectionsButton
import com.rabolista.discovertoronto.ui.components.InlineNavigationBar
import com.rabolista.discovertoronto.ui.components.PlaceImageView
import com.rabolista.discovertoronto.ui.components.asTile
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of CityGuideView.swift (CityGuideView, PlaceSectionView, PlaceRowView, PlaceDetailView)

/** Shared detail-screen frame: inline nav bar + scrolling content on discoverBackground. */
@Composable
fun DetailScaffold(title: String = "", content: @Composable () -> Unit) {
    val nav = LocalNavController.current
    Column(Modifier.fillMaxSize().background(Discover.colors.discoverBackground)) {
        InlineNavigationBar(title = title, onBack = { nav.popBackStack() })
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            content()
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
        }
    }
}

@Composable
fun CityGuideScreen(destination: Destination) {
    val nav = LocalNavController.current
    val sections = CityGuideData.sections(destination.name)
    DetailScaffold {
        Box(Modifier.fillMaxWidth().height(220.dp)) {
            CityImageView(destination.imageName, destination.name, Modifier.fillMaxSize())
            Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)))))
            Column(Modifier.align(Alignment.BottomStart).padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(destination.name, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(destination.region, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.White.copy(alpha = 0.9f))
            }
        }
        if (sections.isEmpty()) {
            Text(
                "More places to visit in ${destination.name} are coming soon.",
                fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray,
                modifier = Modifier.padding(16.dp),
            )
        } else {
            sections.forEach { section ->
                PlaceSectionView(section.title, section.places) { nav.navigate(Routes.place(it.name)) }
            }
        }
    }
}

@Composable
fun PlaceSectionView(title: String, places: List<Place>, onPlace: (Place) -> Unit) {
    Column {
        Text(
            title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Discover.colors.primaryText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 8.dp),
        )
        Column(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            places.forEach { place -> PlaceRowView(place) { onPlace(place) } }
        }
    }
}

@Composable
fun PlaceRowView(place: Place, onClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth().asTile().plainClickable(onClick).padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top,
    ) {
        PlaceImageView(place.imageName, place.systemImage, Modifier.size(56.dp).clip(RoundedCornerShape(10.dp)))
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(place.name, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
            Text(place.category, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
            Text(place.details, fontSize = 12.sp, color = IOSColors.gray)
        }
        Chevron()
    }
}

@Composable
fun PlaceDetailScreen(place: Place) {
    DetailScaffold {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            PlaceImageView(place.imageName, place.systemImage, Modifier.fillMaxWidth().height(220.dp))
            Column(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(place.name, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Discover.colors.primaryText)
                Text(place.category, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
                Text(place.details, fontSize = 15.sp, color = IOSColors.gray, lineHeight = 22.sp)
                if (place.address.isNotEmpty()) {
                    DirectionsButton(place.name, place.address)
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
