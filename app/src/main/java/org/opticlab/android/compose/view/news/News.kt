package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.exhaust
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.ad.Advertisement

@Composable
fun News(
    topics: List<Topic>,
    modifier: Modifier = Modifier
) {
    Stack(modifier = modifier) {
        val (selected, onSelect) = state { topics.first() }

        Column {
            TopicTabs(topics, selected, onSelect)

            LazyColumnItems(
                items = selected.feeds,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    .weight(1f)
            ) { feed ->
                if (selected.feeds.firstOrNull() != feed) {
                    Spacer(modifier = Modifier.height(8.dp))
                }

                NewsItem(feed, Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }

        SearchBar(
            recommendedTags = selected.recommendedTags,
            onSearch = {
                // TODO add a new keyword search tab
            },
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .gravity(Alignment.BottomCenter)
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
        is NewsFeed.Ad -> Advertisement(
            ad = feed.ad,
            modifier = modifier
        ) {

        }
    }.exhaust()
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        News(sampleTopics)
    }
}