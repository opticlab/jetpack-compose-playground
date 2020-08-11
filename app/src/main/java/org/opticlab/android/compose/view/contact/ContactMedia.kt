package org.opticlab.android.compose.view.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.drawBorder
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.preferredWidthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.ui.colorMedia

@Composable
fun ContactMedia(media: Contact.Media, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.drawBorder(
            size = 1.dp,
            color = colorMedia,
            shape = RoundedCornerShape(percent = 50)
        )
            .padding(8.dp),
        verticalGravity = Alignment.CenterVertically
    ) {
        WithConstraints {
            Text(
                text = media.run { "$title - $author" },
                modifier = Modifier.preferredWidthIn(maxWidth = maxWidth - 12.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.caption
            )
        }
        Image(
            asset = vectorResource(id = R.drawable.ic_baseline_music_note_24),
            modifier = Modifier.preferredSize(12.dp),
            colorFilter = ColorFilter.tint(colorMedia)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        ContactMedia(
            media = Contact.Media(
                author = "윤딴딴",
                title = "잘 살고 있지롱"
            )
        )
    }
}