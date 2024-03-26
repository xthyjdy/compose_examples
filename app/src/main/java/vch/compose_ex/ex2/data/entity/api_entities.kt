package vch.compose_ex.ex2.data.entity

//val response: Response = Gson().fromJson(responseJson, Response::class.java)

data class Ex2ApiNewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val source: Source?,
    val author: String?,
    val content: String?,
    val description: String?, // Make description nullable
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

data class Source(
    val id: String?,
    val name: String
)