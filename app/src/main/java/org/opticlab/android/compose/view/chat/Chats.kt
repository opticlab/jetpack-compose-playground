package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.Chat
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.common.AppBar
import org.opticlab.android.compose.view.common.MenuItem

@Composable
fun Chats(
    chats: List<Chat>,
    modifier: Modifier = Modifier,
    onClickChat: (Chat) -> Unit
) {
    Column(modifier = modifier) {
        AppBar(title = "채팅") {
            MenuItem(R.drawable.ic_baseline_search_24) {

            }
            MenuItem(R.drawable.ic_baseline_settings_24) {

            }
        }
        LazyColumnItems(items = chats) { chat ->
            ChatItem(
                chat = chat,
                onClick = onClickChat
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        Chats(chats = sampleChats) {

        }
    }
}