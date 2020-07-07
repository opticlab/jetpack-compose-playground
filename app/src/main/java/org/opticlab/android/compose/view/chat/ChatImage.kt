package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.WithConstraints
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Image
import androidx.ui.foundation.drawBackground
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.ui.SquircleShape

@Composable
fun ChatAvatars(avatars: List<Avatar>, modifier: Modifier = Modifier) {
    WithConstraints(modifier = modifier.aspectRatio(1f)) {
        val size = if (avatars.size < 2) maxWidth else maxWidth / 2

        Box(gravity = ContentGravity.Center) {
            Column {
                avatars.take(4).chunked(2).forEach { rowAvatars ->
                    Row(
                        modifier = Modifier.sizeIn(
                            minWidth = maxWidth / 2,
                            minHeight = maxHeight / 2,
                            maxWidth = maxWidth,
                            maxHeight = maxHeight
                        ).gravity(Alignment.CenterHorizontally)
                    ) {
                        rowAvatars.forEach { avatar ->
                            ChatAvatar(
                                avatar = avatar,
                                modifier = Modifier.size(size)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ChatAvatar(avatar: Avatar, modifier: Modifier = Modifier) {
    Image(
        asset = vectorResource(id = R.drawable.ic_launcher_foreground),
        modifier = modifier
            .aspectRatio(1f)
            .drawBackground(
                color = MaterialTheme.colors.primaryVariant,
                shape = SquircleShape()
            )
            .clip(SquircleShape())
    )
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        ChatAvatars(
            listOf(Avatar.Empty, Avatar.Empty, Avatar.Empty, Avatar.Empty),
            modifier = Modifier.size(56.dp)
        )
    }
}