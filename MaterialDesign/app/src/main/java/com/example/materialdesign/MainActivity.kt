package com.example.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val msg = Message(message = "Message" , body = "body")
                    MessageCard(message = msg)
                }
            }
        }
    }
}

data class Message(
    var message: String = "MessageCard",
    var desc: String = "Message",
    var body: String
)




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MessageCard(
    message: Message)
{
    Row{
        Image(painter = painterResource(id = R.drawable.), contentDescription = )
        Column{
            Text(text = message.message)
            Text(text = message.desc)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialDesignTheme {
        Greeting("Android")
    }
}