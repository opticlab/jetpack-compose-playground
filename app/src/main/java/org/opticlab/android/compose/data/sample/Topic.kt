package org.opticlab.android.compose.data.sample

import org.opticlab.android.compose.data.NewsArticle
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.Weather

val sampleHeadlines = NewsFeed.Headlines(
    listOf(
        NewsArticle.Text("아몰랑 일하기 싫다"),
        NewsArticle.Text("아몰랑 일하기 싫다2"),
        NewsArticle.Text("아몰랑 일하기 싫다3"),
        NewsArticle.Text("아몰랑 일하기 싫다4"),
        NewsArticle.Text("아몰랑 일하기 싫다5")
    )
)
val sampleImages = NewsFeed.Images(
    listOf(
        NewsArticle.Image("일하기 싫어", ""),
        NewsArticle.Image("쨩 시름", "")
    )
)

val sampleWeather = NewsFeed.Weather(
    Weather("성남시 백현동", 36.5f)
)

val sampleFeeds = listOf(
    sampleHeadlines,
    sampleImages,
    sampleWeather
)
val sampleTopics = listOf(
    Topic("코로나19", sampleFeeds),
    Topic("뉴스", sampleFeeds),
    Topic("정치", sampleFeeds),
    Topic("사회", sampleFeeds),
    Topic("경제", sampleFeeds),
    Topic("연예", sampleFeeds),
    Topic("케빈", sampleFeeds),
    Topic("이지", sampleFeeds),
    Topic("티미", sampleFeeds),
    Topic("케이", sampleFeeds),
    Topic("윌슨", sampleFeeds),
    Topic("민스", sampleFeeds)
)