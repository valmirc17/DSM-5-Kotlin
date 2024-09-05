package com.example.materialdesign.ui.components.button

import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text


@Composable
fun CustomElevatedButton(onClick:()-> Unit){
    ElevatedButton(onClick = {onClick}) {
        Text ("Elevated")
    }
}