package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.drawBackground
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
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
                .drawBackground(
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