package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredSizeIn
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.NewsArticle
import org.opticlab.android.compose.data.sample.sampleHeadlines
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsHeadline(
    article: NewsArticle,
    modifier: Modifier = Modifier,
    onClickArticle: (NewsArticle) -> Unit
) {
    Row(
        modifier = Modifier.preferredSizeIn(minHeight = 36.dp)
            .fillMaxWidth()
            .clickable(onClick = { onClickArticle(article) }) + modifier
    ) {
        Text(
            text = article.title,
            modifier = Modifier.gravity(Alignment.CenterVertically),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        NewsHeadline(article = sampleHeadlines.articles.first(), onClickArticle = {})
    }
}