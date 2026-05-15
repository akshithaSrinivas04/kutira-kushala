package com.kutira.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kutira.app.data.BusinessRepository
import com.kutira.app.ui.components.CapacityMeter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(onBack: () -> Unit) {
    // First business represents "my" business in this demo.
    val business = BusinessRepository.businesses.first()

    var name by remember { mutableStateOf(business.name) }
    var owner by remember { mutableStateOf(business.ownerName) }
    var skill by remember { mutableStateOf(business.skillArea) }
    var location by remember { mutableStateOf(business.location) }
    var phone by remember { mutableStateOf(business.phone) }
    var description by remember { mutableStateOf(business.description) }
    var units by remember { mutableIntStateOf(business.capacityUnits) }
    var ready by remember { mutableStateOf(business.readyToTake) }
    var savedSnackbar by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(savedSnackbar) {
        if (savedSnackbar) {
            snackbarHostState.showSnackbar("Profile saved")
            savedSnackbar = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Business", color = MaterialTheme.colorScheme.onPrimary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        BusinessRepository.updateProfile(
                            id = business.id,
                            name = name,
                            ownerName = owner,
                            skillArea = skill,
                            location = location,
                            phone = phone,
                            description = description
                        )
                        BusinessRepository.updateCapacity(business.id, units, ready)
                        savedSnackbar = true
                    }) {
                        Icon(Icons.Filled.Check, contentDescription = "Save", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 12.dp)
        ) {
            CapacityMeter(
                units = units,
                period = business.capacityPeriod,
                ready = ready,
                editable = true,
                onUnitsChange = { units = it },
                onReadyChange = { ready = it }
            )
            Spacer(Modifier.height(20.dp))

            SectionTitle("Business Profile")
            Field("Business name", name) { name = it }
            Field("Owner / family name", owner) { owner = it }
            Field("Skill area", skill) { skill = it }
            Field("Location", location) { location = it }
            Field("Phone (for Direct Connect)", phone) { phone = it }
            Field("About your business", description, lines = 4) { description = it }
            Spacer(Modifier.height(40.dp))
        }
    }
}

@Composable
private fun SectionTitle(t: String) {
    Text(
        t,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
private fun Field(label: String, value: String, lines: Int = 1, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(label) },
        singleLine = lines == 1,
        minLines = lines,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    )
}
