package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.NewsArticle
import org.opticlab.android.compose.data.sample.sampleImages
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsImage(
    article: NewsArticle,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable(onClick = {})
    ) {
        Image(
            asset = vectorResource(id = R.drawable.ic_baseline_amp_stories_24),
            modifier = Modifier
                .aspectRatio(1.333f)
                .background(
                    color = MaterialTheme.colors.primaryVariant,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(MaterialTheme.shapes.medium),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSecondary)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = article.title)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        NewsImage(article = sampleImages.articles.first(), modifier = Modifier.width(180.dp))
    }
}