package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.input.ImeAction
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredHeight
import androidx.ui.material.OutlinedTextField
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.R
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun SearchInput(
    textValue: TextFieldValue,
    onTextValueChange: (TextFieldValue) -> Unit,
    onSearch: (String) -> Unit
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextValueChange,
        label = { Text(text = "검색어를 입력해주세요") },
        leadingIcon = { Icon(asset = vectorResource(id = R.drawable.ic_baseline_music_note_24)) },
        trailingIcon = { Icon(asset = vectorResource(id = R.drawable.ic_baseline_search_24)) },
        modifier = Modifier.fillMaxWidth()
            .preferredHeight(56.dp),
        imeAction = ImeAction.Search,
        onImeActionPerformed = { _, softwareKeyboardController ->
            softwareKeyboardController?.hideSoftwareKeyboard()
            onSearch(textValue.text)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        SearchInput(textValue = TextFieldValue(""), onTextValueChange = {}, onSearch = {})
    }
}