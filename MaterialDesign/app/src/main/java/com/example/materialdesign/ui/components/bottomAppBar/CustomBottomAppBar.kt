package com.example.materialdesign.ui.components.bottomAppBar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BottomAppBarExample(){
    Scaffold (
        bottomBar = {
            BottomAppBar (
                actions =  {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized Description")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = {println("Não clique aqui")}){
                        Icon(
                            Icons.Filled.AccountBox,
                            contentDescription = "Localized description"
                        )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.AccountCircle,
                        contentDescription = "Localized description"
                    )
                }
            },
            floatingActionButton ={
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized Description")
                }
            }
            )}
    ){
        innerPadding -> Text(
            modifier = Modifier.padding(innerPadding),
            text = "Exemple of a scaffold"
        )
    }
}