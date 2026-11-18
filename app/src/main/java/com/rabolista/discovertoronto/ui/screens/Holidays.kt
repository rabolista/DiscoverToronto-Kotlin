package com.rabolista.discovertoronto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabolista.discovertoronto.ui.components.SectionHeader
import com.rabolista.discovertoronto.ui.components.asTile
import com.rabolista.discovertoronto.ui.theme.Discover
import com.rabolista.discovertoronto.ui.theme.IOSColors
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.Locale

// Port of HolidaysView.swift

data class Holiday(val name: String, val date: LocalDate, val note: String) {
    val formattedDate: String get() = date.format(DateTimeFormatter.ofPattern("MMM d", Locale.getDefault()))
}

/** Computes Canadian/Ontario public holidays for any given year. */
fun holidays(year: Int): List<Holiday> {
    fun date(month: Int, day: Int) = LocalDate.of(year, month, day)
    fun nthMonday(nth: Int, month: Int) = date(month, 1).with(TemporalAdjusters.dayOfWeekInMonth(nth, DayOfWeek.MONDAY))
    // Last Monday before May 25
    val victoriaDay = date(5, 24).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

    // Easter (Anonymous Gregorian algorithm)
    val a = year % 19; val b = year / 100; val c = year % 100
    val d = b / 4; val e = b % 4; val f = (b + 8) / 25
    val g = (b - f + 1) / 3; val h = (19 * a + b - d - g + 15) % 30
    val i = c / 4; val k = c % 4; val l = (32 + 2 * e + 2 * i - h - k) % 7
    val m = (a + 11 * h + 22 * l) / 451
    val easterMonth = (h + l - 7 * m + 114) / 31
    val easterDay = ((h + l - 7 * m + 114) % 31) + 1
    val easterSunday = date(easterMonth, easterDay)

    return listOf(
        Holiday("New Year's Day", date(1, 1), "Federal"),
        Holiday("Family Day", nthMonday(3, 2), "Ontario"),
        Holiday("Good Friday", easterSunday.minusDays(2), "Federal"),
        Holiday("Easter Monday", easterSunday.plusDays(1), "Optional"),
        Holiday("Victoria Day", victoriaDay, "Federal"),
        Holiday("Canada Day", date(7, 1), "Federal"),
        Holiday("Civic Holiday", nthMonday(1, 8), "Ontario"),
        Holiday("Labour Day", nthMonday(1, 9), "Federal"),
        Holiday("Thanksgiving", nthMonday(2, 10), "Federal"),
        Holiday("Remembrance Day", date(11, 11), "Federal"),
        Holiday("Christmas Day", date(12, 25), "Federal"),
        Holiday("Boxing Day", date(12, 26), "Ontario"),
    )
}

@Composable
fun HolidaysSection() {
    val year = LocalDate.now(ZoneId.of("America/Toronto")).year
    val items = holidays(year)
    Column {
        SectionHeader("GTA Public Holidays $year", onSeeAll = null)
        Row(
            Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { holiday ->
                Box(
                    Modifier.padding(bottom = 16.dp).width(140.dp).asTile(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(holiday.formattedDate, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = IOSColors.orange)
                        // iOS uses .black here; primaryText keeps it visible in dark mode.
                        Text(holiday.name, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Discover.colors.primaryText)
                        val badge = when (holiday.note) {
                            "Ontario" -> IOSColors.blue
                            "Optional" -> IOSColors.gray
                            else -> IOSColors.red
                        }
                        Text(
                            holiday.note,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(badge).padding(horizontal = 6.dp, vertical = 2.dp),
                        )
                    }
                }
            }
        }
    }
}
