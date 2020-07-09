package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun Tag(tag: String, onClickTag: (String) -> Unit) {
    Text(
        text = "#$tag",
        modifier = Modifier.drawBackground(
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