package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.material.Card
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
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
        Column(modifier = Modifier.padding(horizontal = 16.dp,vertical = 8.dp)) {
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