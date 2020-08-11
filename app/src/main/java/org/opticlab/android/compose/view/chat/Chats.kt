package org.opticlab.android.compose.view.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        LazyColumnFor(
            items = chats,
            contentPadding = InnerPadding(top = 8.dp, bottom = 8.dp)
        ) { chat ->
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