package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.data.Chat
import org.opticlab.android.compose.ui.KakaoTheme
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Composable
fun ChatItem(chat: Chat, onClick: (Chat) -> Unit) {
    Row(
        modifier = Modifier
            .preferredSizeIn(minHeight = 72.dp)
            .clickable(onClick = { onClick(chat) })
            .padding(8.dp),
        verticalGravity = Alignment.CenterVertically
    ) {
        ChatAvatars(chat.avatars, modifier = Modifier.size(56.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = chat.title,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = chat.lastMessage,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = chat.updatedAt.formatDateTime(),
                style = MaterialTheme.typography.caption
            )

            val unreadCount = chat.unreadCount
            if (unreadCount > 0) {
                Spacer(modifier = Modifier.height(4.dp))

                UnreadCount(unreadCount, modifier = Modifier.gravity(Alignment.End))
            }
        }
    }
}

private fun OffsetDateTime.formatDateTime(): String {
    val today = OffsetDateTime.now()
        .truncatedTo(ChronoUnit.DAYS)
    val yesterday = today.minus(1L, ChronoUnit.DAYS)

    return when {
        isBefore(yesterday) -> DateTimeFormatter.ofPattern("MM-dd")
            .format(this)
        isBefore(today) -> "어제"
        isAfter(today) -> DateTimeFormatter.ofPattern("a hh:mm")
            .format(this)
        else -> DateTimeFormatter.ofPattern("yyyy-MM-dd").format(this)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        ChatItem(
            chat = Chat(
                avatars = listOf(Avatar.Empty),
                title = "채팅방 제목",
                lastMessage = "이 것은 다잉 메시지라는 것으로서 불필요하게 말이 많아서 죽은 사람이 남기다 만 메시지를 의미하는 바인 것으로 추정되지만 한편 이게 무엇인지는 아무도 모른다고 합니다.",
                updatedAt = OffsetDateTime.now(),
                unreadCount = 1000
            ),
            onClick = {}
        )
    }
}