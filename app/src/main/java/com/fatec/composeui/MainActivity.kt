package com.fatec.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.fatec.composeui.ui.theme.ComposeUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text("Top App Bar" )
                                          },
                            colors = topAppBarColors(
                                containerColor= MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            )
                        )
                            
                    },

                    bottomBar = {
                        BottomAppBar (
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary
                        ){
                            Text(text = "Bottom App Bar",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center)
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector= Icons.Default.Add,
                                contentDescription = "Add")
                        }
                    }
                        ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Lorem ipsum dolor sit amet, Vestibulum interdum at dui ut ornare. Etiam ullamcorper bibendum ultricies. Vestibulum a mauris nunc. Nam odio leo, tincidunt ut elit sed, molestie euismod erat. Sed mollis viverra dolor, feugiat porta nisi eleifend sit amet. Curabitur non maximus mi, in accumsan turpis. Suspendisse placerat condimentum pharetra. Duis fermentum felis nec blandit ornare. Nullam feugiat hendrerit cursus. Curabitur quis pretium libero, at congue ligula. Etiam nibh augue, convallis quis consectetur in, pellentesque vel diam. Aenean eu dignissim magna, ut facilisis purus. Maecenas malesuada mattis nisl, sit amet pretium dui mattis sed. Sed mollis leo magna, nec vehicula neque condimentum non.\n" +
                "\n" +
                "Ph sdignissim commodo. Fusce in leo quis lectus rutrum tincidunt. Morbi ornare aliquet maximus. Integer lacus nibh, imperdiet a fermentum non, ullamcorper ut tellus. Cras vel dolor sit amet elit sollicitudin cursus. ",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeUITheme {
        Greeting("Android")
    }
}