package com.rabolista.discovertoronto.data

import androidx.annotation.DrawableRes
import com.rabolista.discovertoronto.R

/**
 * Maps the original Assets.xcassets image-set names (used by the data, e.g. "CNTower")
 * to the Android drawables (lowercase snake_case, e.g. R.drawable.cn_tower).
 * Mirrors UIImage(named:) lookups from the SwiftUI app.
 */
object ImageAssets {
    private val map: Map<String, Int> = mapOf(
        "AGO" to R.drawable.ago,
        "Ajax" to R.drawable.ajax,
        "AngusGlen" to R.drawable.angus_glen,
        "art1" to R.drawable.art1,
        "art2" to R.drawable.art2,
        "AutomotiveMuseum" to R.drawable.automotive_museum,
        "barandgrill" to R.drawable.barandgrill,
        "BoydConservation" to R.drawable.boyd_conservation,
        "BradleyMuseum" to R.drawable.bradley_museum,
        "Brampton" to R.drawable.brampton,
        "BrantStreetPier" to R.drawable.brant_street_pier,
        "BronteVillage" to R.drawable.bronte_village,
        "BrucesMill" to R.drawable.bruces_mill,
        "Burlington" to R.drawable.burlington,
        "CasaLoma" to R.drawable.casa_loma,
        "CelebrationSquare" to R.drawable.celebration_square,
        "ChinguacousyPark" to R.drawable.chinguacousy_park,
        "CNTower" to R.drawable.cn_tower,
        "DunlapObservatory" to R.drawable.dunlap_observatory,
        "ErchlessEstate" to R.drawable.erchless_estate,
        "GagePark" to R.drawable.gage_park,
        "GairlochGardens" to R.drawable.gairloch_gardens,
        "HighPark" to R.drawable.high_park,
        "HillcrestMall" to R.drawable.hillcrest_mall,
        "KariyaPark" to R.drawable.kariya_park,
        "Kortright" to R.drawable.kortright,
        "LakeviewPark" to R.drawable.lakeview_park,
        "LakeWilcox" to R.drawable.lake_wilcox,
        "MainStreetUnionville" to R.drawable.main_street_unionville,
        "Mapleview" to R.drawable.mapleview,
        "Markham" to R.drawable.markham,
        "MarkhamMuseum" to R.drawable.markham_museum,
        "McMichael" to R.drawable.mc_michael,
        "Mississauga" to R.drawable.mississauga,
        "NewYork" to R.drawable.new_york,
        "Oakville" to R.drawable.oakville,
        "Oshawa" to R.drawable.oshawa,
        "OshawaBotanicalGardens" to R.drawable.oshawa_botanical_gardens,
        "PacificMall" to R.drawable.pacific_mall,
        "PAMA" to R.drawable.pama,
        "PortCredit" to R.drawable.port_credit,
        "ProfessorsLake" to R.drawable.professors_lake,
        "RattlesnakePoint" to R.drawable.rattlesnake_point,
        "RichmondHill" to R.drawable.richmond_hill,
        "RipleysAquarium" to R.drawable.ripleys_aquarium,
        "ROM" to R.drawable.rom,
        "RoseTheatre" to R.drawable.rose_theatre,
        "RotaryPark" to R.drawable.rotary_park,
        "RoyalBotanicalGardens" to R.drawable.royal_botanical_gardens,
        "SquareOne" to R.drawable.square_one,
        "tapas" to R.drawable.tapas,
        "Tokyo" to R.drawable.tokyo,
        "ToogoodPond" to R.drawable.toogood_pond,
        "Toronto3" to R.drawable.toronto3,
        "TorontoIslands" to R.drawable.toronto_islands,
        "Vaughan" to R.drawable.vaughan,
        "VaughanMills" to R.drawable.vaughan_mills,
        "YongeDundasSquare" to R.drawable.yonge_dundas_square,
    )

    @DrawableRes
    fun drawable(name: String): Int? = if (name.isEmpty()) null else map[name]
}
