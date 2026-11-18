package com.rabolista.discovertoronto.ui.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

/** Plain clickable without ripple — mirrors `.buttonStyle(.plain)` on NavigationLinks. */
fun Modifier.plainClickable(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(interactionSource = null, indication = null, onClick = onClick)
)

/**
 * iOS-style inline navigation bar (`.navigationBarTitleDisplayMode(.inline)`):
 * blue "< Back" on the leading side, 17pt semibold centred title.
 */
@Composable
fun InlineNavigationBar(
    title: String,
    onBack: (() -> Unit)?,
    background: Color = Discover.colors.discoverBackground,
    leading: (@Composable RowScope.() -> Unit)? = null,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(background)
            .windowInsetsPadding(WindowInsets.statusBars)
            .height(44.dp)
    ) {
        Text(
            title,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = Discover.colors.primaryText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 96.dp),
        )
        Row(Modifier.align(Alignment.CenterStart).padding(start = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            if (leading != null) {
                leading()
            } else if (onBack != null) {
                Row(
                    Modifier.plainClickable(onBack).padding(vertical = 8.dp, horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBackIos, "Back", tint = IOSColors.blue, modifier = Modifier.size(20.dp))
                    Text("Back", fontSize = 17.sp, color = IOSColors.blue)
                }
            }
        }
    }
}

/** "Popular Destinations ........ See all" header used by each Discover section. */
@Composable
fun SectionHeader(title: String, onSeeAll: (() -> Unit)?) {
    Row(
        Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
        Spacer(Modifier.weight(1f))
        if (onSeeAll != null) {
            Text(
                "See all",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = IOSColors.blue,
                modifier = Modifier.plainClickable(onSeeAll),
            )
        }
    }
}

@Composable
fun Chevron(size: Int = 12) {
    Icon(SfSymbol.icon("chevron.right"), null, tint = IOSColors.gray, modifier = Modifier.size((size + 8).dp))
}

/** "Get Directions" button used on place / restaurant detail screens. */
@Composable
fun DirectionsButton(name: String, address: String) {
    val context = LocalContext.current
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Discover.colors.systemBackground)
            .clickable { openInMaps(context, name, address) }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Box(
            Modifier.size(32.dp).clip(RoundedCornerShape(8.dp)).background(IOSColors.orange),
            contentAlignment = Alignment.Center,
        ) {
            Icon(SfSymbol.icon("map.fill"), null, tint = Color.White, modifier = Modifier.size(16.dp))
        }
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text("Get Directions", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
            Text(address, fontSize = 12.sp, color = IOSColors.gray)
        }
        Chevron(11)
    }
}

/** Equivalent of opening `maps://?q=name, address` — uses a geo: intent, falling back to Google Maps on the web. */
fun openInMaps(context: Context, name: String, address: String) {
    val query = Uri.encode("$name, $address")
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$query")))
    } catch (e: ActivityNotFoundException) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=$query")))
    }
}
