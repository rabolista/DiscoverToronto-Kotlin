package com.rabolista.discovertoronto.data

import com.rabolista.discovertoronto.model.Place

/** Helpers to look up data by name for navigation arguments. */
object Catalog {
    val allPlaces: List<Place> by lazy {
        GTACities.all.flatMap { dest -> CityGuideData.sections(dest.name).flatMap { it.places } }
    }

    fun placeNamed(name: String): Place? = allPlaces.firstOrNull { it.name == name }
}
