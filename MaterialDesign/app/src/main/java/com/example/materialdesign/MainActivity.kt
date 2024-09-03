package com.example.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialdesign.ui.components.CustomActionButton
import com.example.materialdesign.ui.components.CustomBottomAppBar
import com.example.materialdesign.ui.components.CustomTopAppBar


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignTheme {
                Text(text = "TESTE")
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CustomTopAppBar(title = "Só Bagunça")
                    },
                    bottomBar = {
                        CustomBottomAppBar()
                    },
                    floatingActionButton = {
                        CustomActionButton()
                    }
                )
                { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

class MaterialDesignTheme(function: @Composable () -> Unit) {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Lorem ipsum dolor sit amet, Vestibulum interdum at dui ut ornare. Etiam ullamcorper bibendum ultricies. Vestibulum a mauris nunc. Nam odio leo, tincidunt ut elit sed, molestie euismod erat. Sed mollis viverra dolor, feugiat porta nisi eleifend sit amet. Curabitur non maximus mi, in accumsan turpis. Suspendisse placerat condimentum pharetra. Duis fermentum felis nec blandit ornare. Nullam feugiat hendrerit cursus. Curabitur quis pretium libero, at congue ligula. Etiam nibh augue, convallis quis consectetur in, pellentesque vel diam. Aenean eu dignissim magna, ut facilisis purus. Maecenas malesuada mattis nisl, sit amet pretium dui mattis sed. Sed mollis leo magna, nec vehicula neque condimentum non",
        modifier = modifier
    )
}


@Composable
fun TopBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .weight(.2f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Titulo",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(.8f),
                color = Color.Black
            )
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
    isImpar: Boolean
) {
    //Alinhar a mensagem inteira à esquerda ou direita
    val alignment = if (isImpar) Arrangement.Start else Arrangement.End
    val backgroundColor = if (isImpar) Color.Red else Color.Blue
    val textStyle =
        if (isImpar) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge

    Row(
        modifier = Modifier
            .padding(all = 9.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        horizontalArrangement = alignment
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "Imagem do Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(width = 1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = message.message,
                color = MaterialTheme.colorScheme.secondary,
                style = textStyle
            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 2.dp) {
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
    Surface(
        modifier = Modifier
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        val msg = Message(message = "Message", body = "body")
        MessageCard(message = msg, isImpar = true)
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        //colocar topBar aqui
        TopBar()
        LazyColumn {
            itemsIndexed(messages) { index, message ->
                val isImpar = index % 2 == 1
                MessageCard(message = message, isImpar = isImpar)
            }
        }
        Row {
            Modifier
                .fillMaxWidth();

            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )


        }
    }
}


@Preview(showBackground = true)
@Composable
fun ConversationPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Conversation(messages = SampleData.conversationSample)


    }
}

object SampleData {
    val conversationSample = listOf(
        Message("Mensagem 0", body = "Body A"),
        Message("Mensagem 1", body = "Body A"),
        Message("Mensagem 2", body = "Body A"),
        Message("Mensagem 3", body = "Body A"),
        Message("Mensagem 4", body = "Body A"),
        Message("Mensagem 5", body = "Body A")
    )


}
