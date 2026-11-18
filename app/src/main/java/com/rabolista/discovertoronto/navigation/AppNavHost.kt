package com.rabolista.discovertoronto.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rabolista.discovertoronto.ui.theme.Discover
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rabolista.discovertoronto.data.Catalog
import com.rabolista.discovertoronto.data.GTACities
import com.rabolista.discovertoronto.data.GTACreators
import com.rabolista.discovertoronto.data.GTARestaurants
import com.rabolista.discovertoronto.ui.screens.AllCreatorsScreen
import com.rabolista.discovertoronto.ui.screens.AllDestinationsScreen
import com.rabolista.discovertoronto.ui.screens.AllRestaurantsScreen
import com.rabolista.discovertoronto.ui.screens.CategoryDetailsScreen
import com.rabolista.discovertoronto.ui.screens.CityGuideScreen
import com.rabolista.discovertoronto.ui.screens.CreatorDetailScreen
import com.rabolista.discovertoronto.ui.screens.DiscoverCategories
import com.rabolista.discovertoronto.ui.screens.DiscoverScreen
import com.rabolista.discovertoronto.ui.screens.PlaceDetailScreen
import com.rabolista.discovertoronto.ui.screens.RestaurantDetailScreen
import com.rabolista.discovertoronto.ui.screens.SearchScreen

private fun NavBackStackEntry.nameArg(): String = arguments?.getString("name").orEmpty()

@Composable
fun AppNavHost(prefersDarkMode: Boolean, onToggleDarkMode: () -> Unit) {
    val nav = rememberNavController()

    // Status bar icons: white over the orange header (and in dark mode), dark elsewhere.
    val entry by nav.currentBackStackEntryAsState()
    val isDark = Discover.colors.isDark
    val view = LocalView.current
    val lightIcons = isDark || entry?.destination?.route == Routes.DISCOVER
    SideEffect {
        val window = (view.context as? Activity)?.window ?: return@SideEffect
        WindowCompat.getInsetsController(window, view).apply {
            isAppearanceLightStatusBars = !lightIcons
            isAppearanceLightNavigationBars = !isDark
        }
    }
    CompositionLocalProvider(LocalNavController provides nav) {
        NavHost(
            navController = nav,
            startDestination = Routes.DISCOVER,
            // iOS-style push / pop
            enterTransition = { slideInHorizontally(tween(300)) { it } },
            exitTransition = { slideOutHorizontally(tween(300)) { -it / 3 } },
            popEnterTransition = { slideInHorizontally(tween(300)) { -it / 3 } },
            popExitTransition = { slideOutHorizontally(tween(300)) { it } },
        ) {
            composable(Routes.DISCOVER) {
                DiscoverScreen(prefersDarkMode = prefersDarkMode, onToggleDarkMode = onToggleDarkMode)
            }
            // SearchView is presented as a sheet on iOS -> slide up from the bottom here.
            composable(
                Routes.SEARCH,
                enterTransition = { slideInVertically(tween(350)) { it } },
                exitTransition = { fadeOut(tween(300)) },
                popEnterTransition = { fadeIn(tween(300)) },
                popExitTransition = { slideOutVertically(tween(350)) { it } },
            ) { SearchScreen() }
            composable(Routes.ALL_DESTINATIONS) { AllDestinationsScreen(GTACities.all) }
            composable(Routes.ALL_RESTAURANTS) { AllRestaurantsScreen(GTARestaurants.top30) }
            composable(Routes.ALL_CREATORS) { AllCreatorsScreen(GTACreators.all) }
            composable(Routes.CITY) { entry ->
                GTACities.all.firstOrNull { it.name == entry.nameArg() }?.let { CityGuideScreen(it) }
            }
            composable(Routes.PLACE) { entry ->
                Catalog.placeNamed(entry.nameArg())?.let { PlaceDetailScreen(it) }
            }
            composable(Routes.RESTAURANT) { entry ->
                GTARestaurants.top30.firstOrNull { it.name == entry.nameArg() }?.let { RestaurantDetailScreen(it) }
            }
            composable(Routes.CREATOR) { entry ->
                GTACreators.all.firstOrNull { it.name == entry.nameArg() }?.let { CreatorDetailScreen(it) }
            }
            composable(Routes.CATEGORY) { entry ->
                DiscoverCategories.categories.firstOrNull { it.name == entry.nameArg() }?.let { CategoryDetailsScreen(it) }
            }
        }
    }
}
