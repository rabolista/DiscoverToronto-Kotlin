package com.rabolista.discovertoronto.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Maps the SF Symbol names used in the SwiftUI app to the closest Material icon.
 * (SF Symbols are Apple-only, so this is the closest visual equivalent.)
 */
object SfSymbol {
    fun icon(name: String): ImageVector = when (name) {
        "anchor.fill" -> Icons.Filled.Anchor
        "bag.fill" -> Icons.Filled.ShoppingBag
        "basket.fill" -> Icons.Filled.ShoppingBasket
        "beach.umbrella.fill" -> Icons.Filled.BeachAccess
        "birthday.cake.fill" -> Icons.Filled.Cake
        "birthday.cake" -> Icons.Outlined.Cake
        "building.2.crop.circle.fill" -> Icons.Filled.LocationCity
        "building.2.fill" -> Icons.Filled.Apartment
        "building.columns.fill" -> Icons.Filled.AccountBalance
        "books.vertical.fill" -> Icons.AutoMirrored.Filled.MenuBook
        "car.fill" -> Icons.Filled.DirectionsCar
        "cart.fill" -> Icons.Filled.ShoppingCart
        "crown.fill" -> Icons.Filled.Castle
        "cup.and.saucer.fill" -> Icons.Filled.LocalCafe
        "drop.fill" -> Icons.Filled.WaterDrop
        "drop.triangle.fill" -> Icons.Filled.Opacity
        "figure.golf" -> Icons.Filled.GolfCourse
        "figure.sailing", "sailboat.fill" -> Icons.Filled.Sailing
        "figure.skiing.downhill" -> Icons.Filled.DownhillSkiing
        "figure.walk" -> Icons.AutoMirrored.Filled.DirectionsWalk
        "fish.fill" -> Icons.Filled.SetMeal
        "flag.checkered" -> Icons.Filled.SportsScore
        "flame.fill" -> Icons.Filled.LocalFireDepartment
        "fork.knife" -> Icons.Filled.Restaurant
        "house.fill" -> Icons.Filled.Home
        "leaf.fill" -> Icons.Filled.Eco
        "leaf.arrow.circlepath", "leaf.arrow.triangle.circlepath" -> Icons.Filled.Recycling
        "mountain.2.fill" -> Icons.Filled.Landscape
        "paintpalette.fill" -> Icons.Filled.Palette
        "sparkles" -> Icons.Filled.AutoAwesome
        "sportscourt.fill" -> Icons.Filled.SportsBasketball
        "star.circle.fill" -> Icons.Filled.Stars
        "star.fill" -> Icons.Filled.Star
        "sun.max.fill" -> Icons.Filled.WbSunny
        "moon.fill" -> Icons.Filled.DarkMode
        "takeoutbag.and.cup.and.straw.fill" -> Icons.Filled.Fastfood
        "theatermasks.fill" -> Icons.Filled.TheaterComedy
        "ticket.fill" -> Icons.Filled.ConfirmationNumber
        "tree.fill" -> Icons.Filled.Park
        "music.mic" -> Icons.Filled.Mic
        "magnifyingglass" -> Icons.Filled.Search
        "exclamationmark.magnifyingglass" -> Icons.Filled.SearchOff
        "map.fill" -> Icons.Filled.Map
        "mappin.circle.fill" -> Icons.Filled.LocationOn
        "person.circle.fill" -> Icons.Filled.AccountCircle
        "xmark.circle.fill" -> Icons.Filled.Cancel
        "chevron.right" -> Icons.AutoMirrored.Filled.KeyboardArrowRight
        else -> Icons.Filled.Place
    }
}
