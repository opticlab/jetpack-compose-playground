package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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