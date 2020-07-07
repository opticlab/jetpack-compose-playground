package org.opticlab.android.compose.data

sealed class NewsArticle {
    abstract val title: String

    data class Text(override val title: String) : NewsArticle()
    data class Image(override val title: String, val image: String) : NewsArticle()
}