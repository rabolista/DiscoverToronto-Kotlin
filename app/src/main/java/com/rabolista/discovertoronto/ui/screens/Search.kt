package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.GTACities
import com.rabolista.discovertoronto.data.GTACreators
import com.rabolista.discovertoronto.data.GTARestaurants
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.InlineNavigationBar
import com.rabolista.discovertoronto.ui.components.PlaceImageView
import com.rabolista.discovertoronto.ui.components.SfSymbol
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of SearchView.swift (presented as a sheet from DiscoverView)

@Composable
fun SearchScreen() {
    val nav = LocalNavController.current
    val colors = Discover.colors
    var searchText by rememberSaveable { mutableStateOf("") }

    val q = searchText.trim()
    val destinations = if (q.isEmpty()) emptyList() else GTACities.all.filter {
        it.name.contains(q, ignoreCase = true) || it.region.contains(q, ignoreCase = true)
    }
    val restaurants = if (q.isEmpty()) emptyList() else GTARestaurants.top30.filter {
        it.name.contains(q, true) || it.cuisine.contains(q, true) || it.city.contains(q, true)
    }
    val creators = if (q.isEmpty()) emptyList() else GTACreators.all.filter {
        it.name.contains(q, true) || it.category.contains(q, true)
    }
    val hasResults = destinations.isNotEmpty() || restaurants.isNotEmpty() || creators.isNotEmpty()

    // insetGrouped list colours (systemGroupedBackground / secondarySystemGroupedBackground)
    val groupedBackground = if (colors.isDark) Color.Black else Color(0xFFF2F2F7)
    val cellBackground = if (colors.isDark) Color(0xFF1C1C1E) else Color.White
    val screenBackground = if (q.isNotEmpty() && hasResults) groupedBackground else colors.systemBackground

    Column(Modifier.fillMaxSize().background(screenBackground).imePadding()) {
        InlineNavigationBar(
            title = "Search",
            onBack = null,
            background = screenBackground,
            leading = {
                Text(
                    "Cancel", fontSize = 17.sp, color = IOSColors.blue,
                    modifier = Modifier.plainClickable { nav.popBackStack() }.padding(8.dp),
                )
            },
        )
        // .searchable(placement: .navigationBarDrawer(displayMode: .always))
        Row(
            Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colors.searchBarFill)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Icon(SfSymbol.icon("magnifyingglass"), null, tint = IOSColors.gray, modifier = Modifier.size(20.dp))
            Box(Modifier.weight(1f)) {
                if (searchText.isEmpty()) {
                    Text("Where in the GTA do you want to go?", fontSize = 17.sp, color = IOSColors.gray, maxLines = 1)
                }
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 17.sp, color = colors.primaryText),
                    cursorBrush = SolidColor(IOSColors.blue),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            if (searchText.isNotEmpty()) {
                Icon(
                    SfSymbol.icon("xmark.circle.fill"), "Clear", tint = IOSColors.gray,
                    modifier = Modifier.size(18.dp).plainClickable { searchText = "" },
                )
            }
        }

        when {
            q.isEmpty() -> CenteredMessage("magnifyingglass", IOSColors.orange.copy(alpha = 0.6f), "Search GTA cities, restaurants, and creators")
            !hasResults -> CenteredMessage("exclamationmark.magnifyingglass", IOSColors.gray.copy(alpha = 0.5f), "No results for \"$searchText\"")
            else -> Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                if (destinations.isNotEmpty()) {
                    GroupedSection("Cities", cellBackground) {
                        destinations.forEachIndexed { i, destination ->
                            GroupedRow(showDivider = i > 0, onClick = { nav.navigate(Routes.city(destination.name)) }) {
                                Box(Modifier.size(36.dp), contentAlignment = Alignment.Center) {
                                    Icon(SfSymbol.icon("mappin.circle.fill"), null, tint = IOSColors.orange, modifier = Modifier.size(26.dp))
                                }
                                TwoLine(destination.name, destination.region)
                            }
                        }
                    }
                }
                if (restaurants.isNotEmpty()) {
                    GroupedSection("Restaurants", cellBackground) {
                        restaurants.forEachIndexed { i, restaurant ->
                            GroupedRow(showDivider = i > 0, onClick = { nav.navigate(Routes.restaurant(restaurant.name)) }) {
                                PlaceImageView(
                                    restaurant.name, restaurant.systemImage,
                                    Modifier.size(36.dp).clip(RoundedCornerShape(8.dp)), iconSize = 18,
                                )
                                TwoLine(restaurant.name, "${restaurant.cuisine} • ${restaurant.city}")
                            }
                        }
                    }
                }
                if (creators.isNotEmpty()) {
                    GroupedSection("Creators", cellBackground) {
                        creators.forEachIndexed { i, user ->
                            GroupedRow(showDivider = i > 0, onClick = null) {
                                Icon(SfSymbol.icon("person.circle.fill"), null, tint = IOSColors.orange, modifier = Modifier.size(40.dp))
                                TwoLine(user.name, user.category)
                            }
                        }
                    }
                }
                Spacer(Modifier.height(24.dp))
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
            }
        }
    }
}

@Composable
private fun CenteredMessage(symbol: String, tint: Color, message: String) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
    ) {
        Icon(SfSymbol.icon(symbol), null, tint = tint, modifier = Modifier.size(56.dp))
        Text(
            message, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.gray,
            textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 32.dp),
        )
    }
}

@Composable
private fun GroupedSection(title: String, cellBackground: Color, content: @Composable () -> Unit) {
    Text(
        title.uppercase(), fontSize = 13.sp, color = IOSColors.gray,
        modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 24.dp, bottom = 6.dp),
    )
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(cellBackground)
    ) { content() }
}

@Composable
private fun GroupedRow(showDivider: Boolean, onClick: (() -> Unit)?, content: @Composable () -> Unit) {
    Column {
        if (showDivider) HorizontalDivider(Modifier.padding(start = 64.dp), thickness = 0.5.dp, color = Discover.colors.separator)
        Row(
            Modifier
                .fillMaxWidth()
                .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
                .heightIn(min = 44.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                content()
            }
            if (onClick != null) {
                Icon(SfSymbol.icon("chevron.right"), null, tint = Color(0xFFC4C4C6), modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
private fun TwoLine(title: String, subtitle: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
        Text(subtitle, fontSize = 12.sp, color = IOSColors.gray)
    }
}
