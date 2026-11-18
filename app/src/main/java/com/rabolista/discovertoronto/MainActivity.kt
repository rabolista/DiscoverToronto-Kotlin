package com.rabolista.discovertoronto

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.rabolista.discovertoronto.navigation.AppNavHost
import com.rabolista.discovertoronto.ui.theme.DiscoverTorontoTheme

/** Port of TravelDiscoveryRABApp.swift — @AppStorage("prefersDarkMode") becomes SharedPreferences. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        setContent {
            var prefersDarkMode by remember { mutableStateOf(prefs.getBoolean("prefersDarkMode", false)) }
            DiscoverTorontoTheme(darkTheme = prefersDarkMode) {
                AppNavHost(
                    prefersDarkMode = prefersDarkMode,
                    onToggleDarkMode = {
                        prefersDarkMode = !prefersDarkMode
                        prefs.edit().putBoolean("prefersDarkMode", prefersDarkMode).apply()
                    },
                )
            }
        }
    }
}
