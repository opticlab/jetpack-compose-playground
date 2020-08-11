package org.opticlab.android.compose.view.chat

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun UnreadCount(count: Int, modifier: Modifier = Modifier, maxVisible: Int = MAX_DISPLAY_COUNT) {
    Text(
        text = count.formatUnreadCount(maxVisible),
        modifier = modifier.preferredSizeIn(minWidth = 16.dp, minHeight = 16.dp)
            .background(
                color = MaterialTheme.colors.error,
                shape = RoundedCornerShape(percent = 50)
            )
            .padding(
                start = 4.dp,
                end = 4.dp
            ),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onError,
        style = MaterialTheme.typography.caption
    )
}

private fun Int.formatUnreadCount(maxVisible: Int): String = when (this) {
    in 1..maxVisible -> toString()
    else -> "${maxVisible}+"
}

const val MAX_DISPLAY_COUNT = 300

@Preview(name = "Short")
@Composable
private fun ShortPreview() {
    UnreadCount(count = 1)
}

@Preview(name = "Long")
@Composable
private fun LongPreview() {
    UnreadCount(count = MAX_DISPLAY_COUNT)
}

@Preview(name = "Overflow")
@Composable
private fun OverflowPreview() {
    UnreadCount(count = MAX_DISPLAY_COUNT + 1)
}