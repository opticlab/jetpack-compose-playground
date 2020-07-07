package org.opticlab.android.compose.data.sample

import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.data.Chat
import java.time.OffsetDateTime
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

val sampleChats = (1..30).map {
    Chat(
        avatars = List(it) { Avatar.Empty },
        title = "$it 채팅방",
        lastMessage = "마지막 메시지는 지 맘대로 $it",
        updatedAt = OffsetDateTime.now()
            .minusHours(Random.nextLong(0L..(24L * 7))),
        unreadCount = Random.nextInt(0..300)
    )
}