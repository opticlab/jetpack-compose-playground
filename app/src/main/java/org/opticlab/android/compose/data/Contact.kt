package org.opticlab.android.compose.data

data class Contact(
    val avatar: Avatar,
    val name: String,
    val status: String?,
    val media: Media?
) {
    data class Media(
        val author: String,
        val title: String
    )
}