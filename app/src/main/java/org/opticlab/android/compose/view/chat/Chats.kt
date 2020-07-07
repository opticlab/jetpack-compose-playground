package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Add
import androidx.ui.material.icons.filled.Search
import androidx.ui.material.icons.filled.Settings
import androidx.ui.tooling.preview.Preview
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
            MenuItem(Icons.Default.Search) {

            }
            MenuItem(Icons.Default.Add) {
                
            }
            MenuItem(Icons.Default.Settings) {

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