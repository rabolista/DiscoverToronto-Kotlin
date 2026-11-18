package com.rabolista.discovertoronto.model

// Kotlin equivalents of Models/*.swift (Category, Destination, Place, PlaceSection, Restaurant, User)

/** Category.swift — imageName is an SF Symbol name (mapped to a Material icon via SfSymbol). */
data class Category(val name: String, val imageName: String)

/** Destination.swift */
data class Destination(val name: String, val region: String, val imageName: String)

/** Place.swift */
data class Place(
    val name: String,
    val category: String,
    val details: String,
    val systemImage: String,
    val imageName: String = "",
    val address: String = "",
)

/** PlaceSection.swift */
data class PlaceSection(val title: String, val places: List<Place>)

/** Restaurant.swift */
data class Restaurant(
    val name: String,
    val cuisine: String,
    val priceRange: String,
    val city: String,
    val details: String,
    val systemImage: String,
    val rating: Double,
    val address: String = "",
) {
    /** "%.1f • cuisine • priceRange" line used across the restaurant views. */
    val summary: String get() = "${String.format(java.util.Locale.US, "%.1f", rating)} • $cuisine • $priceRange"
}

/** User.swift */
data class User(val name: String, val imageName: String, val category: String, val tagline: String)
