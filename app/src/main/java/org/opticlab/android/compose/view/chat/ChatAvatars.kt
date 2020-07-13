package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.ExperimentalLayout
import androidx.ui.layout.FlowRow
import androidx.ui.layout.size
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.common.Grid

@Composable
fun ChatAvatars(avatars: List<Avatar>, modifier: Modifier = Modifier) {
    Grid(
        items = avatars,
        spanCount = 2,
        modifier = modifier
    ) { avatar ->
        ChatAvatar(avatar)
    }
}

@OptIn(ExperimentalLayout::class)
@Preview(widthDp = 56 * 4)
@Composable
private fun Preview() {
    KakaoTheme {
        FlowRow {
            (1..4).forEach { count ->
                ChatAvatars(List(count) { Avatar.Empty }, Modifier.size(56.dp))
            }
        }
    }
}