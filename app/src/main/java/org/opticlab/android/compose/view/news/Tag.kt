package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun Tag(tag: String, onClickTag: (String) -> Unit) {
    Text(
        text = "#$tag",
        modifier = Modifier.background(
            color = MaterialTheme.colors.secondaryVariant,
            shape = RoundedCornerShape(
                50
            )
        )
            .clickable(
                onClick = { onClickTag(tag) }
            )
            .clip(
                RoundedCornerShape(
                    50
                )
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        fontSize = MaterialTheme.typography.caption.fontSize,
        color = MaterialTheme.colors.onSecondary
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        Tag("해시태그") {}
    }
}