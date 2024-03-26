package vch.compose_ex

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vch.compose_ex.ui.theme.Compose_exTheme

//https://developer.android.com/jetpack/compose/tutorial
//https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1
//https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#9


@Composable
fun RowExample(ls: List<Message>) {
    Row() {
        Column() {
            ls.forEachIndexed { index, _ ->
                Text(text = index.toString())
            }
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ex2_nasa_logo),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = "author - ${message.author}",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun PreviewUI() {
    Compose_exTheme() {
        RowExample(listOfMessages)
//        Surface(modifier = Modifier.fillMaxSize()) {
//            Conversation(messages = listOfMessages)
//        }
    }
}
//data
data class Message(val author: String, val body: String)
val listOfMessages: List<Message> = listOf(
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
    Message("a1", "b1"),
    Message("a2", "B2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b\t\b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2"),
    Message("a3", "b3"),
)
//
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_exTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(messages = listOfMessages)
                }
            }
        }
//        setContent {
//            example()
//
//            Compose_exTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Androidt1")
//                }
//            }
//        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MessageCard("222")
////    Compose_exTheme {
////        Greeting("Android")
////    }
//}