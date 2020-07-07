package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.padding
import androidx.ui.layout.preferredSizeIn
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun UnreadCount(count: Int, modifier: Modifier = Modifier) {
    Text(
        text = count.formatUnreadCount(),
        modifier = modifier.preferredSizeIn(minWidth = 16.dp, minHeight = 16.dp)
            .drawBackground(
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

private fun Int.formatUnreadCount(): String = when (this) {
    in 1..MAX_DISPLAY_COUNT -> toString()
    else -> "${MAX_DISPLAY_COUNT}+"
}

private const val MAX_DISPLAY_COUNT = 300

@Preview(name = "Short")
@Composable
private fun ShortPreview() {
    UnreadCount(count = 1)
}

@Preview(name = "Long")
@Composable
private fun LongPreview() {
    UnreadCount(count = 300)
}

@Preview(name = "Overflow")
@Composable
private fun OverflowPreview() {
    UnreadCount(count = 1000)
}