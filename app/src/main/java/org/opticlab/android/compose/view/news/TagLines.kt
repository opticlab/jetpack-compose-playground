package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.layout.ExperimentalLayout
import androidx.ui.layout.FlowRow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
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