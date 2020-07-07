package org.opticlab.android.compose.data

sealed class Avatar {
    data class Url(val value: String) : Avatar()
    object Empty : Avatar()
}