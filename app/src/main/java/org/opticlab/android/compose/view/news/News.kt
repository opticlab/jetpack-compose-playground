package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun News(topics: List<Topic>, modifier: Modifier = Modifier) {
    val (selected, onSelect) = state { topics.first() }

    Column {
        TopicTabs(topics, selected, onSelect)

        LazyColumnItems(
            items = selected.feeds,
            modifier = modifier.padding(top = 8.dp, bottom = 8.dp)
                .weight(1f)
        ) { feed ->
            if (selected.feeds.firstOrNull() != feed) {
                Spacer(modifier = Modifier.height(8.dp))
            }

            val paddingModifier = Modifier.padding(start = 16.dp, end = 16.dp)

            when (feed) {
                is NewsFeed.Headlines -> NewsHeadlines(
                    headlines = feed,
                    modifier = paddingModifier
                )
                is NewsFeed.Images -> NewsImages(
                    images = feed,
                    modifier = paddingModifier
                )
                is NewsFeed.Weather -> NewsWeather(
                    weather = feed,
                    modifier = paddingModifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        News(sampleTopics)
    }
}