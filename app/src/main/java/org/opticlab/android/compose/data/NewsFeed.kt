package org.opticlab.android.compose.data

sealed class NewsFeed {
    data class Headlines(val articles: List<NewsArticle>) : NewsFeed()
    data class Images(val articles: List<NewsArticle.Image>) : NewsFeed()
    data class Weather(val weather: org.opticlab.android.compose.data.Weather) : NewsFeed()
}
