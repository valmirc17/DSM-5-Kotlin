package com.example.materialdesign

import android.annotation.SuppressLint
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

             /*       Surface(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
                        val msg = Message(message = "Message", body = "body")
                        MessageCard(message = msg)

              */
                    }
                    Conversation(messages = SampleData.conversationSample)

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
fun MessageCard(
    message: Message,
    isRightAligned: Boolean,
    colors: Boolean,
    fontStyle: FontStyle
) {
    Row(modifier = Modifier
                        .padding(all = 9.dp)
                        .fillMaxWidth()
                        .background( if (colors)Color.Red else Color.Blue)
        ,
        horizontalArrangement = if(isRightAligned) Arrangement.End else Arrangement.Start,
        )
        {
        Image(

            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "Imagem do Avatat",
            modifier = Modifier
                //altera o tam da imagem
                .size(40.dp)
                //Corta a img em algum formato(ex. Circle,Square)
                .clip(CircleShape)
                .border(width = 1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

        )
        Spacer(modifier = Modifier
                        .width(8.dp))

        Column {
            Text(
                text = message.message,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge


            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 2.dp){
                Text(
                    text = message.desc,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    Surface(modifier = Modifier
                        .padding(WindowInsets.systemBars.asPaddingValues())
                        .absoluteOffset(0.dp)

    ) {
        val msg = Message(message = "Message", body = "body")
        MessageCard(message = msg, isRightAligned = false, colors = false, fontStyle = )
    }
}


@Composable
fun Conversation (messages: List<Message>){
    LazyColumn {
        itemsIndexed(messages){index, message ->
            MessageCard(message = message, isRightAligned = index % 2 == 0, colors = index %2 == 0)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationPreview (){

    Surface ( modifier = Modifier
                        .fillMaxSize()
    ){
       Conversation(messages = SampleData.conversationSample) 
    }
}


object SampleData{
    val conversationSample = listOf(
        Message("Mensagem 0", body = "Body A"),
        Message("Mensagem 1", body = "Body A"),
        Message("Mensagem 2", body = "Body A"),
        Message("Mensagem 3", body = "Body A"),
        Message("Mensagem 4", body = "Body A"),
        Message("Mensagem 5", body = "Body A")
    )
}