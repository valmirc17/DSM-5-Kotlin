package com.example.materialdesign.ui.components.topAppBar


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import com.example.materialdesign.ui.components.utils.ScrollContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Small top App Bar")
                }
            )}
    ) {
        innerPadding -> 
        ScrollContent(innerPadding = innerPadding)

    }
}