package org.opticlab.android.compose.view.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
            .background(
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