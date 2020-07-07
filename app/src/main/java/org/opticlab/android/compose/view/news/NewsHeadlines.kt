package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.Divider
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.sample.sampleHeadlines
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsHeadlines(headlines: NewsFeed.Headlines, modifier: Modifier = Modifier) {
    Column {
        headlines.articles.forEachIndexed { index, article ->
            if (index > 0) {
                Divider(modifier = modifier.fillMaxWidth())
            }
            NewsHeadline(article = article, modifier = modifier) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        NewsHeadlines(headlines = sampleHeadlines)
    }
}