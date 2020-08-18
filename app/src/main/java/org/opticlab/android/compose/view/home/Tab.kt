package org.opticlab.android.compose.view.home

import androidx.annotation.DrawableRes
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.Ad
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.data.sample.sampleTopics

sealed class Tab(@DrawableRes val icon: Int) {
    data class Contacts(val contacts: List<Contact>) : Tab(R.drawable.ic_baseline_people_24)
    data class Chat(val chats: List<org.opticlab.android.compose.data.Chat>) : Tab(R.drawable.ic_baseline_chat_24)
    data class News(val topics: List<Topic>) : Tab(R.drawable.ic_baseline_dashboard_24)
    data class Etc(val ad: Ad) : Tab(R.drawable.ic_baseline_apps_24)
}

val tabs = listOf(
    Tab.Contacts(sampleContacts),
    Tab.Chat(sampleChats),
    Tab.News(sampleTopics),
    Tab.Etc(sampleAd),
)