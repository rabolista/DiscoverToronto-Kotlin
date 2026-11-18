package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.data.GTACreators
import com.rabolista.discovertoronto.model.User
import com.rabolista.discovertoronto.navigation.LocalNavController
import com.rabolista.discovertoronto.navigation.Routes
import com.rabolista.discovertoronto.ui.components.AvatarImageView
import com.rabolista.discovertoronto.ui.components.Chevron
import com.rabolista.discovertoronto.ui.components.SectionHeader
import com.rabolista.discovertoronto.ui.components.asTile
import com.rabolista.discovertoronto.ui.components.plainClickable
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors

// Port of TrendingCreatorsView.swift (TrendingCreatorsView, AllCreatorsView, CreatorDetailView)

private val grayTextShadow = Shadow(color = IOSColors.gray, offset = Offset(0f, 4f), blurRadius = 8f)

@Composable
fun TrendingCreatorsSection(users: List<User> = GTACreators.all) {
    val nav = LocalNavController.current
    Column {
        SectionHeader("GTA Creators to Follow") { nav.navigate(Routes.ALL_CREATORS) }
        Row(
            Modifier.horizontalScroll(rememberScrollState()).padding(start = 16.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top,
        ) {
            users.forEach { user ->
                Column(
                    Modifier.width(80.dp).padding(bottom = 16.dp).plainClickable { nav.navigate(Routes.creator(user.name)) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    AvatarImageView(
                        user.imageName, user.name,
                        Modifier.size(60.dp).shadow(4.dp, CircleShape, ambientColor = IOSColors.gray, spotColor = IOSColors.gray),
                    )
                    Text(
                        user.name,
                        style = TextStyle(shadow = grayTextShadow),
                        fontSize = 11.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center,
                        color = Discover.colors.primaryText,
                    )
                    Text(
                        user.category,
                        style = TextStyle(shadow = grayTextShadow),
                        fontSize = 10.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center,
                        color = IOSColors.gray,
                    )
                }
            }
        }
    }
}

@Composable
fun AllCreatorsScreen(users: List<User>) {
    val nav = LocalNavController.current
    DetailScaffold(title = "GTA Creators") {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            users.forEach { user ->
                Row(
                    Modifier.fillMaxWidth().asTile().plainClickable { nav.navigate(Routes.creator(user.name)) }.padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AvatarImageView(user.imageName, user.name, Modifier.size(50.dp))
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(user.name, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                        Text(user.category, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
                        Text(user.tagline, fontSize = 12.sp, color = IOSColors.gray)
                    }
                    Chevron()
                }
            }
        }
    }
}

@Composable
fun CreatorDetailScreen(user: User) {
    DetailScaffold {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Brush.linearGradient(listOf(IOSColors.orange, IOSColors.red))),
                contentAlignment = Alignment.Center,
            ) {
                AvatarImageView(
                    user.imageName, user.name,
                    Modifier.offset(y = 45.dp).size(90.dp).border(3.dp, Color.White, CircleShape),
                )
            }
            Column(
                Modifier.padding(top = 56.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text(user.name, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Discover.colors.primaryText)
                Text(user.category, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = IOSColors.orange)
                Text(
                    user.tagline, fontSize = 14.sp, color = IOSColors.gray, textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp),
                )
            }
            HorizontalDivider(Modifier.padding(horizontal = 16.dp), color = Discover.colors.separator)
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    // iOS hard-codes Color.white here; systemBackground keeps it readable in dark mode.
                    .background(Discover.colors.systemBackground),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    "About", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Discover.colors.primaryText,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                )
                Text(
                    "${user.name} is a Toronto-based content creator focused on ${user.category.lowercase()}. " +
                        "Follow along for the best local tips, hidden gems, and recommendations across the GTA.",
                    fontSize = 14.sp, color = IOSColors.gray, lineHeight = 21.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                )
            }
        }
    }
}
