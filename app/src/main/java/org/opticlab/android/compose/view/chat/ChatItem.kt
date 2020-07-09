package org.opticlab.android.compose.view.chat

import androidx.compose.Composable
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
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeightIn(minHeight = 72.dp)
            .clickable(onClick = { onClick(chat) })
            .padding(8.dp)
    ) {
        val (avatars, title, message, updatedAt, unreadCount) = createRefs()

        ChatAvatars(
            avatars = chat.avatars,
            modifier = Modifier.size(56.dp)
                .constrainAs(avatars) {
                    start.linkTo(parent.start)
                    centerVerticallyTo(parent)
                }
        )
        Text(
            text = chat.title,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(title) {
                width = Dimension.fillToConstraints
                start.linkTo(avatars.end, margin = 8.dp)
                end.linkTo(updatedAt.start, margin = 8.dp)
                top.linkTo(parent.top)
            }
        )
        Text(
            text = chat.lastMessage,
            style = MaterialTheme.typography.subtitle2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(message) {
                width = Dimension.fillToConstraints
                start.linkTo(title.start)
                end.linkTo(title.end)
                top.linkTo(title.bottom, margin = 4.dp)
                bottom.linkTo(parent.bottom)
            }
        )
        createVerticalChain(title, message, chainStyle = ChainStyle.Packed)
        Text(
            text = chat.updatedAt.formatDateTime(),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.constrainAs(updatedAt) {
                width = Dimension.wrapContent
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(unreadCount.top)
            }
        )
        if (chat.unreadCount > 0) {
            UnreadCount(
                count = chat.unreadCount,
                modifier = Modifier.constrainAs(unreadCount) {
                    end.linkTo(parent.end)
                    top.linkTo(updatedAt.bottom, 4.dp)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
        createVerticalChain(updatedAt, unreadCount, chainStyle = ChainStyle.Packed)
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