package org.opticlab.android.compose.data

import java.time.OffsetDateTime

data class Chat(
    val avatars: List<Avatar>,
    val title: String,
    val lastMessage: String,
    val updatedAt: OffsetDateTime,
    val unreadCount: Int
)

