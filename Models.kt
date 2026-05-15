package com.kutira.app.data

enum class Category(val label: String, val emoji: String) {
    ALL("All", "🌐"),
    FOOD("Food", "🍛"),
    CRAFT("Craft", "🧵"),
    INCENSE("Incense", "🕯"),
    TEXTILE("Textile", "🧶"),
    POTTERY("Pottery", "🏺")
}

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val wholesalePrice: Int,
    val unit: String,
    val emoji: String
)

data class Business(
    val id: String,
    val name: String,
    val ownerName: String,
    val skillArea: String,
    val location: String,
    val phone: String,
    val category: Category,
    val emoji: String,
    val description: String,
    val products: List<Product>,
    val capacityUnits: Int,
    val capacityPeriod: String,
    val readyToTake: Boolean
)
