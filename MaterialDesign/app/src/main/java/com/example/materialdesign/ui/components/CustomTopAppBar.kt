package com.example.materialdesign.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomTopAppBar(
    title:String
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontFamily= FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }
    )
}