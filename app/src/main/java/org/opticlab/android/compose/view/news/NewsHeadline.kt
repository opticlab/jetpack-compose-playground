package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredSizeIn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
            .clickable(onClick = { onClickArticle(article) })
            .then(modifier)
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