package com.kutira.app.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList

/**
 * In-memory repository. Drop-in replacement boundary for Firebase Firestore later.
 */
object BusinessRepository {
    val businesses = SampleData.businesses.toMutableStateList()

    fun getById(id: String): Business? = businesses.firstOrNull { it.id == id }

    fun updateCapacity(id: String, units: Int, ready: Boolean) {
        val idx = businesses.indexOfFirst { it.id == id }
        if (idx >= 0) {
            businesses[idx] = businesses[idx].copy(
                capacityUnits = units,
                readyToTake = ready
            )
        }
    }

    fun updateProfile(
        id: String,
        name: String,
        ownerName: String,
        skillArea: String,
        location: String,
        phone: String,
        description: String
    ) {
        val idx = businesses.indexOfFirst { it.id == id }
        if (idx >= 0) {
            businesses[idx] = businesses[idx].copy(
                name = name,
                ownerName = ownerName,
                skillArea = skillArea,
                location = location,
                phone = phone,
                description = description
            )
        }
    }
}
