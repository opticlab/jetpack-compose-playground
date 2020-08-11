package org.opticlab.android.compose.view.news

import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.sample.sampleRecommendedTags
import org.opticlab.android.compose.ui.KakaoTheme

@OptIn(ExperimentalLayout::class)
@Composable
fun TagLines(
    recommendedTags: List<String>,
    onClickTag: (String) -> Unit
) {
    FlowRow(
        mainAxisSpacing = 4.dp,
        crossAxisSpacing = 4.dp
    ) {
        recommendedTags.forEach { tag -> Tag(tag, onClickTag) }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        TagLines(recommendedTags = sampleRecommendedTags, onClickTag = {})
    }
}