package com.example.materialdesign.ui.components.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable

@Composable
fun CustomFABLarge(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Large floating action button")
    }
}