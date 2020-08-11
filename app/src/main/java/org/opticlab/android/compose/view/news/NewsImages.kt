package org.opticlab.android.compose.view.news

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.sample.sampleImages
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsImages(images: NewsFeed.Images, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        images.articles.forEachIndexed { index, article ->
            if (index > 0) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            NewsImage(article, Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        NewsImages(images = sampleImages)
    }
}