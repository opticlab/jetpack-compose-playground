package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Layout
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.drawBackground
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Person
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.ui.SquircleShape

@Composable
fun ChatAvatars(avatars: List<Avatar>, modifier: Modifier = Modifier, spanCount: Int = 2) {
    Layout(
        children = {
            avatars.take(spanCount * spanCount)
                .forEach { avatar -> ChatAvatar(avatar = avatar) }
        },
        modifier = modifier.aspectRatio(1f),
        measureBlock = { list, constraints, _ ->
            val avatarCount = list.size

            val spanSize = if (avatarCount < spanCount) {
                constraints.maxWidth / avatarCount
            } else {
                constraints.maxWidth / spanCount
            }
            val avatarConstraints = Constraints(
                DpConstraints.fixed(spanSize.toDp(), spanSize.toDp())
            )

            val placeables = list.map { it.measure(avatarConstraints) }

            layout(constraints.maxWidth, constraints.maxHeight) {
                val rows = placeables.chunked(spanCount)

                val rowCount = (placeables.size + (spanCount - 1)) / spanCount

                val centerYOffset = if (rowCount < spanCount) {
                    (constraints.maxHeight - rowCount * spanSize) / 2
                } else {
                    0
                }

                rows.forEachIndexed { y, row ->
                    val columnCount = row.size

                    val yOffset = centerYOffset + spanSize * y
                    val centerXOffset = if (columnCount < spanCount) {
                        (constraints.maxWidth - columnCount * spanSize) / 2
                    } else {
                        0
                    }

                    row.forEachIndexed { x, placeable ->
                        val xOffset = centerXOffset + spanSize * x
                        placeable.place(xOffset, yOffset)
                    }
                }
            }
        }
    )
}

@Composable
private fun ChatAvatar(avatar: Avatar, modifier: Modifier = Modifier) {
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

@OptIn(ExperimentalLayout::class)
@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Row {
            (1..4).forEach { count ->
                ChatAvatars(List(count) { Avatar.Empty }, Modifier.size(56.dp))
            }
        }
    }
}