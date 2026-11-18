package com.rabolista.discovertoronto.navigation

import android.net.Uri
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

/** Navigation Compose routes — one per SwiftUI NavigationLink destination / sheet. */
object Routes {
    const val DISCOVER = "discover"
    const val SEARCH = "search"
    const val ALL_DESTINATIONS = "destinations"
    const val ALL_RESTAURANTS = "restaurants"
    const val ALL_CREATORS = "creators"
    const val CITY = "city/{name}"
    const val PLACE = "place/{name}"
    const val RESTAURANT = "restaurant/{name}"
    const val CREATOR = "creator/{name}"
    const val CATEGORY = "category/{name}"

    fun city(name: String) = "city/${Uri.encode(name)}"
    fun place(name: String) = "place/${Uri.encode(name)}"
    fun restaurant(name: String) = "restaurant/${Uri.encode(name)}"
    fun creator(name: String) = "creator/${Uri.encode(name)}"
    fun category(name: String) = "category/${Uri.encode(name)}"
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}
