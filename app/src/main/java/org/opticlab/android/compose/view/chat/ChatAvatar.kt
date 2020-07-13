package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.drawBackground
import androidx.ui.layout.aspectRatio
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Person
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.ui.SquircleShape

@Composable
fun ChatAvatar(avatar: Avatar, modifier: Modifier = Modifier) {
    Image(
        asset = Icons.Default.Person,
        modifier = modifier
            .aspectRatio(1f)
            .drawBackground(
                color = MaterialTheme.colors.primaryVariant,
                shape = SquircleShape()
            )
            .clip(SquircleShape()),
        contentScale = ContentScale.Fit
    )
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        ChatAvatar(avatar = sampleChats.first().avatars.first())
    }
}