package com.rabolista.discovertoronto.data

import com.rabolista.discovertoronto.model.User

// Fictional creator personas representing popular GTA content niches (not tied to real individuals).
// Converted from GTACreators.swift
object GTACreators {
    val all: List<User> = listOf(
        User(name = "The 6ix Foodie", imageName = "", category = "Food Reviews", tagline = "Ranking the GTA's best hidden food spots"),
        User(name = "GTA Explorer", imageName = "", category = "Hidden Gems", tagline = "Weekend adventures across the Greater Toronto Area"),
        User(name = "416 Eats", imageName = "", category = "Restaurant Reviews", tagline = "Honest reviews from Toronto's food scene"),
        User(name = "Toronto Wanderer", imageName = "", category = "Photography", tagline = "Capturing the city one block at a time"),
        User(name = "GTA Weekend Guide", imageName = "", category = "Events & Things To Do", tagline = "What's on across the GTA this weekend"),
        User(name = "905 Diaries", imageName = "", category = "Suburb Life", tagline = "Exploring life beyond downtown Toronto"),
    )
}
