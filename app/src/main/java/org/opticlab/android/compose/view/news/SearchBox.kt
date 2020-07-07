package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.compose.emptyContent
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.input.ImeAction
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.OutlinedTextField
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.R
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
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        ) {
            val (textValue, onTextValueChange) = state { TextFieldValue() }

            SearchInput(textValue, onTextValueChange, onSearch)
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

@Composable
fun SearchInput(
    textValue: TextFieldValue,
    onTextValueChange: (TextFieldValue) -> Unit,
    onSearch: (String) -> Unit
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextValueChange,
        label = emptyContent(),
        leadingIcon = {
            Icon(asset = vectorResource(id = R.drawable.ic_baseline_music_note_24))
        },
        trailingIcon = {
            Icon(asset = vectorResource(id = R.drawable.ic_baseline_search_24))
        },
        placeholder = { Text(text = "검색어를 입력해주세요") },
        modifier = Modifier.fillMaxWidth()
            .preferredHeight(56.dp),
        imeAction = ImeAction.Search,
        onImeActionPerformed = { _, softwareKeyboardController ->
            softwareKeyboardController?.hideSoftwareKeyboard()
            onSearch(textValue.text)
        }
    )
}

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
        recommendedTags.forEach { tag ->
            Text(
                text = "#$tag",
                modifier = Modifier.drawBackground(
                    color = MaterialTheme.colors.secondaryVariant,
                    shape = RoundedCornerShape(50)
                )
                    .clickable(
                        onClick = { onClickTag(tag) }
                    )
                    .clip(RoundedCornerShape(50))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                fontSize = MaterialTheme.typography.caption.fontSize,
                color = MaterialTheme.colors.onSecondary
            )
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