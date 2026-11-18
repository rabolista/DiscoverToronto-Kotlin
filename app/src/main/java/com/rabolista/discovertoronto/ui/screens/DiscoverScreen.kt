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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.SfSymbol
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover

/** Port of DiscoverView.swift — the home screen. */
@Composable
fun DiscoverScreen(prefersDarkMode: Boolean, onToggleDarkMode: () -> Unit) {
    val nav = LocalNavController.current
    val colors = Discover.colors
    val scroll = rememberScrollState()
    val largeTitlePx = with(LocalDensity.current) { 52.dp.toPx() }
    val collapsed = (scroll.value / largeTitlePx).coerceIn(0f, 1f)

    Box(Modifier.fillMaxSize()) {
        // LinearGradient(headerGradientColors, top -> bottom).ignoresSafeArea()
        Box(Modifier.fillMaxSize().background(Brush.verticalGradient(colors.headerGradient)))
        // Color.discoverBackground.offset(y: 400)
        Box(Modifier.fillMaxSize().offset(y = 400.dp).background(colors.discoverBackground))

        Column(Modifier.fillMaxSize()) {
            // Navigation bar: inline title fades in as the large title scrolls away, moon/sun toggle on the right.
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(colors.headerGradient.first().copy(alpha = collapsed))
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .height(44.dp)
            ) {
                Text(
                    "Discover Toronto",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center).alpha(collapsed),
                )
                Icon(
                    SfSymbol.icon(if (prefersDarkMode) "sun.max.fill" else "moon.fill"),
                    contentDescription = "Toggle dark mode",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(22.dp)
                        .plainClickable(onToggleDarkMode),
                )
            }

            Column(Modifier.fillMaxSize().verticalScroll(scroll)) {
                // .navigationTitle("Discover Toronto") — large title, white
                Text(
                    "Discover Toronto",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp, top = 2.dp, bottom = 6.dp).alpha(1f - collapsed),
                )

                // Search button -> SearchView sheet
                Row(
                    Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(colors.searchFieldFill)
                        .plainClickable { nav.navigate(Routes.SEARCH) }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(SfSymbol.icon("magnifyingglass"), null, tint = Color.White, modifier = Modifier.size(18.dp))
                    Text("Where in the GTA do you want to go?", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    Spacer(Modifier.weight(1f))
                }

                DiscoverCategoriesRow()

                Column(
                    Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(colors.discoverBackground)
                ) {
                    PopularDestinationsSection()
                    PopularRestaurantsSection()
                    TrendingCreatorsSection()
                    HolidaysSection()
                    Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
                }
            }
        }
    }
}
