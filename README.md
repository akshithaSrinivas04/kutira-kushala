# Kutira — Kushala (Self-Employment)

**MindMatrix VTU Internship Program — Project 58**
Android App Development using GenAI

A "Micro-Factory Showcase" that turns invisible cottage industries (basket weaving, agarbatti rolling, papad making, handlooms, pottery) into discoverable, professional-looking businesses that bulk buyers can trust.

---

## Features (Spec checklist)

| Spec | Where it lives |
|---|---|
| **Business Profile** — photo, skill area, location | `MyProfileScreen.kt`, `BusinessDetailScreen.kt` (hero) |
| **Product Catalog** — items with photos & wholesale prices | `BusinessDetailScreen.kt` — `ProductRow` |
| **Capacity Meter** — manual toggle, e.g. "Ready for 500 units this week" | `CapacityMeter.kt` (editable on My Profile, read-only on Detail) |
| **Direct Connect** — call button for bulk buyers | `BusinessDetailScreen.kt` — Extended FAB launches `ACTION_DIAL` |
| **Search by Product Category** (Food, Craft, etc.) | `HomeScreen.kt` + `CategoryFilter.kt` |
| **Clean, product-focused UI** | Material 3 theme, warm earthy palette, high-contrast text |

## Tech

- **Kotlin** + **Jetpack Compose** (modern Android UI)
- **Material 3** design system with custom Kutira palette
- **Navigation Compose** for screen routing
- In-memory `BusinessRepository` (drop-in replacement boundary for **Firebase Firestore** — see "Migrating to Firebase" below)
- Min SDK 24 (Android 7.0), Target SDK 34

## Build & Run

```bash
# Open the project folder in Android Studio (Hedgehog or newer)
# Or from CLI with a local Gradle / Android SDK:
./gradlew assembleDebug
```

Then run on any emulator or physical device.

## Screens

1. **Home** — searchable, category-filterable list of home businesses with a Ready/Booked badge.
2. **Business Detail** — hero, capacity meter, about, product catalog, prominent "Direct Connect" call FAB.
3. **My Business** — edit profile fields and update capacity in one tap.

## Migrating to Firebase Firestore (next step)

The repository is isolated in `data/BusinessRepository.kt`. To wire Firestore:

1. Add `firebase-bom`, `firebase-firestore-ktx`, `firebase-storage-ktx` to `app/build.gradle.kts`.
2. Replace the in-memory `mutableStateListOf` with a `Flow<List<Business>>` from a Firestore `collection("businesses").snapshots()`.
3. Replace `updateProfile` / `updateCapacity` with `documentRef.update(...)`.
4. For images, swap the `emoji` field for a `coil-compose` `AsyncImage` pulling from Firebase Storage URLs.

The whole UI layer is already isolated from data source — zero UI changes required.

## Design Notes (the "letters not blending" rule)

Every text element uses `MaterialTheme.colorScheme.onX` against its container colour, so contrast is guaranteed regardless of theme tweaks:

- `onPrimary` on `primary` (top app bar, FAB)
- `onSurface` on `surface` (cards)
- `onSecondaryContainer` on `secondaryContainer` (capacity meter pill)
- `onBackground` on `background` (body text)

No hard-coded text colors anywhere. Tested visually for WCAG AA.

## Impact Goals (per spec)

- **Rural Industrialization** — strengthens the base of the manufacturing pyramid
- **Women's Empowerment** — sample data reflects women-led collectives
- **Atmanirbhar** — encourages local production of daily-use items

## Folder layout

```
kutira/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/kutira/app/
│       │   ├── MainActivity.kt          # Nav host + 3 destinations
│       │   ├── data/
│       │   │   ├── Models.kt            # Business, Product, Category
│       │   │   ├── SampleData.kt        # 5 seed businesses
│       │   │   └── BusinessRepository.kt
│       │   └── ui/
│       │       ├── theme/               # Color, Theme, Type
│       │       ├── components/          # BusinessCard, CapacityMeter, CategoryFilter
│       │       └── screens/             # Home, BusinessDetail, MyProfile
│       └── res/                         # icons, theme xml
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```
