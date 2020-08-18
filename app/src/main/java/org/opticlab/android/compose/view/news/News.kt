package org.opticlab.android.compose.view.news

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandlerAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.exhaust
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.AnalyticsAmbient
import org.opticlab.android.compose.view.ad.Advertisement

@Composable
fun News(
    topics: List<Topic>,
    modifier: Modifier = Modifier,
    onAddSearchTopic: (String) -> Unit
) {
    Column(modifier = modifier) {
        val (selected, onSelect) = state { topics.first() }

        TopicTabs(topics, selected, onSelect)

        LazyColumnForIndexed(
            items = selected.feeds,
            contentPadding = InnerPadding(top = 8.dp, bottom = 8.dp),
            modifier = Modifier.weight(1f)
        ) { index, feed ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(8.dp))
            }

            NewsItem(feed, Modifier.padding(start = 16.dp, end = 16.dp))
        }

        SearchBar(
            recommendedTags = selected.recommendedTags,
            onSearch = onAddSearchTopic,
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
        )
    }
}

@Composable
private fun NewsItem(
    feed: NewsFeed,
    modifier: Modifier = Modifier
) {
    when (feed) {
        is NewsFeed.Headlines -> NewsHeadlines(
            headlines = feed,
            modifier = modifier
        )
        is NewsFeed.Images -> NewsImages(
            images = feed,
            modifier = modifier
        )
        is NewsFeed.Weather -> NewsWeather(
            weather = feed,
            modifier = modifier
        )
        is NewsFeed.Ad -> {
            val analytics = AnalyticsAmbient.current
            val uriHandler = UriHandlerAmbient.current

            Advertisement(
                ad = feed.ad,
                modifier = modifier
            ) {
                uriHandler.openUri(feed.ad.url)
                analytics.event("News AD", "uri" to feed.ad.url)
            }
        }
    }.exhaust()
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        News(sampleTopics) {}
    }
}