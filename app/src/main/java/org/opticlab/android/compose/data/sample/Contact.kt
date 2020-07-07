package org.opticlab.android.compose.data.sample

import org.opticlab.android.compose.data.Avatar
import org.opticlab.android.compose.data.Contact

private val KOREAN_RANGE = ('가'..'힣').map { it }

val sampleContacts = listOf(
    Contact(
        avatar = Avatar.Empty,
        name = "김표준",
        status = "대충 표준적인 상태 메시지임을 상정하지만 상태 메시지가 너무 길어서 잘릴 수도 있다는 점을 간과하지는 않은 적절한 상태 메시지",
        media = Contact.Media(
            author = "이노래",
            title = "듣고 싶지 않지는 않은 그런 노래일지도 모르지만 일단 들어보는 걸로 하기로 정했다는 그런 노래"
        )
    ),
    Contact(
        avatar = Avatar.Empty,
        name = "비표준",
        status = null,
        media = null
    ),
    Contact(
        avatar = Avatar.Empty,
        name = "반표준",
        status = "대충 표준적인 상태 메시지임을 상정하지만 상태 메시지가 너무 길어서 잘릴 수도 있다는 점을 간과하지는 않은 적절한 상태 메시지",
        media = null
    ),
    Contact(
        avatar = Avatar.Empty,
        name = "준표김",
        status = null,
        media = Contact.Media(
            author = "이노래",
            title = "겁나 짧음"
        )
    )
)