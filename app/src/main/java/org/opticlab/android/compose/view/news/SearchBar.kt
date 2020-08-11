package org.opticlab.android.compose.view.news

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.sample.sampleRecommendedTags
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.ui.shapes

@Composable
fun SearchBar(
    recommendedTags: List<String>,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = shapes.medium.copy(
            bottomLeft = CornerSize(0),
            bottomRight = CornerSize(0)
        ),
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp,vertical = 8.dp)
                .animateContentSize()
        ) {
            val (textValue, onTextValueChange) = state { TextFieldValue() }

            SearchInput(textValue, onTextValueChange, onSearch)

            if (recommendedTags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                TagLines(
                    recommendedTags = recommendedTags,
                    onClickTag = { tag ->
                        onTextValueChange(TextFieldValue(tag))
                        onSearch(tag)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        SearchBar(recommendedTags = sampleRecommendedTags, onSearch = {})
    }
}