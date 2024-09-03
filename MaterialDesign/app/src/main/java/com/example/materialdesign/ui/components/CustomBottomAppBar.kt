package com.example.materialdesign.ui.components

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import java.lang.reflect.Modifier

@Composable
fun CustomBottomAppBar(

) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "Bottom App Basaffsafasfsafsar",
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

