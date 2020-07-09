package org.opticlab.android.compose.view.contact

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.WithConstraints
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBorder
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.layout.preferredSize
import androidx.ui.layout.preferredWidthIn
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
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