package com.example.materialdesign.ui.components.button

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomOutinedButton(onClick: ()-> Unit){
    OutlinedButton(onClick = { onClick() }) {
        Text("Oulined")
    }
}