package vch.compose_ex.ex2.ui_ex2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import vch.compose_ex.ex2.data.entity.Article
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse
import vch.compose_ex.ex2.data.entity.Source
import vch.compose_ex.ui.theme.*;

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "example",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = vch.compose_ex.R.drawable.ex2_placeholder),
            error = painterResource(id = vch.compose_ex.R.drawable.ex2_placeholder)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorTextComponent(article.author, article.source?.name)
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = vch.compose_ex.R.drawable.ex2_empty_page), contentDescription = null)
        
        Spacer(modifier = Modifier.size(20.dp))
        
        HeadingTextComponent(textValue = "Empty Eesource", centredAligned = true)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsRowComponentPreview() {
    val article = Article(
        source = Source("0", "def source"),
        author = "def author",
        content = "def content; def content; def content; def content; \n\n def " +
                "content; def content; def content; \n\n def content; ",
        description = "def description; def description; def description; def description; " +
                "def description; def description; ",
        publishedAt = "01,01,2012",
        title = "def title",
        url = "",
        urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/SMPTE_Color_Bars.svg/200px-SMPTE_Color_Bars.svg.png"
    )
    NewsRowComponent(page = 1, article = article)
}

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String, centredAligned: Boolean = false) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            textAlign = if (centredAligned) TextAlign.Center else null
        )
    )
}

@Composable
fun AuthorTextComponent(name: String?, source: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 24.dp)) {
        name?.also {
            Text(text = it)
        }
        Spacer(modifier = Modifier.weight(1f))
        
        source?.also {
            Text(text = it)
        }
    }
}