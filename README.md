# Discover Toronto — Android (Kotlin + Jetpack Compose)

A native Android port of the SwiftUI app **Discover Toronto**
([rabolista/DiscoverToronto](https://github.com/rabolista/DiscoverToronto), local project
`~/Development/SwiftUI/TravelDiscoveryRAB`). It's a travel discovery app for the Greater Toronto Area,
with the same screens, layout, colours, sizes, images, navigation, and content as the iOS app.

* Package: `com.rabolista.discovertoronto`
* Kotlin 2.0.21 · AGP 8.7.3 · Gradle 8.11.1 (wrapper) · Compose BOM 2024.12.01 · Material 3
* Navigation Compose 2.8.5 · Coil 2.7.0 (remote images) · minSdk 26 · target/compile SDK 35 · JDK 17

## Build & run

```bash
./gradlew assembleDebug                      # APK: app/build/outputs/apk/debug/app-debug.apk
./gradlew installDebug                       # install on a running emulator/device
adb shell am start -n com.rabolista.discovertoronto/.MainActivity
```

`local.properties` points `sdk.dir` at `~/Library/Android/sdk`.

## SwiftUI → Kotlin mapping

| SwiftUI (TravelDiscoveryRAB/) | Kotlin (app/src/main/java/com/rabolista/discovertoronto/) |
|---|---|
| `TravelDiscoveryRABApp.swift` (`@AppStorage("prefersDarkMode")`) | `MainActivity.kt` (SharedPreferences `prefersDarkMode`) |
| `Discover/DiscoverView.swift` (`DiscoverView`, `Color.discoverBackground`) | `ui/screens/DiscoverScreen.kt` (`DiscoverScreen`), `ui/theme/Theme.kt` |
| `Discover/DiscoverCategoriesView.swift` (`DiscoverCategoriesView`, `CategoryDetailsView`) | `ui/screens/DiscoverCategories.kt` (`DiscoverCategoriesRow`, `CategoryDetailsScreen`) |
| `Discover/PopularDestinationsView.swift` (`PopularDestinationsView`, `AllDestinationsView`) | `ui/screens/PopularDestinations.kt` (`PopularDestinationsSection`, `AllDestinationsScreen`) |
| `Discover/PopularRestaurantsView.swift` (`PopularRestaurantsView`, `AllRestaurantsView`, `RestaurantDetailView`) | `ui/screens/PopularRestaurants.kt` (`PopularRestaurantsSection`, `AllRestaurantsScreen`, `RestaurantDetailScreen`) |
| `Discover/TrendingCreatorsView.swift` (`TrendingCreatorsView`, `AllCreatorsView`, `CreatorDetailView`) | `ui/screens/TrendingCreators.kt` (`TrendingCreatorsSection`, `AllCreatorsScreen`, `CreatorDetailScreen`) |
| `Discover/HolidaysView.swift` (`Holiday`, `holidays(for:)`, `HolidaysView`) | `ui/screens/Holidays.kt` (`Holiday`, `holidays(year)`, `HolidaysSection`) |
| `Discover/CityGuideView.swift` (`CityGuideView`, `PlaceSectionView`, `PlaceRowView`, `PlaceDetailView`) | `ui/screens/CityGuide.kt` (`CityGuideScreen`, `PlaceSectionView`, `PlaceRowView`, `PlaceDetailScreen`, `DetailScaffold`) |
| `Discover/SearchView.swift` (sheet + `.searchable`) | `ui/screens/Search.kt` (`SearchScreen`, slides up like a sheet) |
| `Models/Category, Destination, Place, PlaceSection, Restaurant, User.swift` | `model/Models.kt` (data classes) |
| `Models/GTACities.swift` | `data/GTACities.kt` |
| `Models/GTACreators.swift` | `data/GTACreators.kt` |
| `Models/GTARestaurants.swift` | `data/GTARestaurants.kt` |
| `Models/CityGuideData.swift` | `data/CityGuideData.kt` (+ `data/Catalog.kt` lookups) |
| `Utils/PlaceholderImageViews.swift` (`CityImageView`, `PlaceImageView`, `AvatarImageView`) | `ui/components/ImageViews.kt` |
| `Utils/TileModifier.swift` (`.asTile()`) | `ui/components/Tile.kt` (`Modifier.asTile()`) |
| `NavigationStack` / `NavigationLink` | `navigation/AppNavHost.kt`, `navigation/Routes.kt` |
| SF Symbols | `ui/components/SfSymbol.kt` (closest Material icons) |
| iOS nav bar, "See all" headers, "Get Directions" | `ui/components/Common.kt` |
| `Assets.xcassets/*.imageset` | `res/drawable-nodpi/*.jpg` (snake_case names, resized to max 1200 px), `data/ImageAssets.kt` |
| `AppIcon.appiconset` | `res/mipmap-*/ic_launcher*.png` |

## Notes on the port

* **Fonts:** SF Pro is Apple-only. The app uses the Android system font (Roboto) at the same point sizes and weights.
* **Icons:** SF Symbols are mapped to the closest Material icons (`SfSymbol.kt`).
* **Images:** bundled photos are copied from the asset catalog. Like the iOS app, anything without a bundled photo
  (restaurants, the CNE) loads a seeded photo from picsum.photos, creator avatars come from DiceBear, and
  each falls back to the same gradient/initials/icon placeholders when offline.
* **Navigation bar:** recreated with Compose to look like iOS (large white title that collapses on the
  home screen; inline title with a blue "Back" button on pushed screens).
* **Directions:** iOS opens `maps://`. Android opens a `geo:` intent, with Google Maps on the web as a fallback.
* **Dark mode:** the moon/sun toggle persists like `@AppStorage`. Two hard-coded colours from iOS (the black
  holiday name and the white creator "About" card) follow the theme instead, so they stay readable in dark mode.
