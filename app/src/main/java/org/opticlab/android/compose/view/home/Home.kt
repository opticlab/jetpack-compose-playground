package org.opticlab.android.compose.view.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Ad
import org.opticlab.android.compose.data.Chat
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.chat.Chats
import org.opticlab.android.compose.view.contact.Contacts
import org.opticlab.android.compose.view.etc.Etc
import org.opticlab.android.compose.view.news.News

@Composable
fun Home(
    contacts: List<Contact>,
    chats: List<Chat>,
    topics: List<Topic>,
    ad: Ad
) {
    val (selected, onSelect) = savedInstanceState(inputs = Tab.values()) { Tab.NEWS }

    Scaffold(
        bottomBar = {
            TalkTabs(
                selected = selected,
                onTabSelected = onSelect
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding).fillMaxSize()

        when (selected) {
            Tab.CONTACTS -> Contacts(contacts, modifier) {
            }
            Tab.CHAT -> Chats(chats, modifier) {
            }
            Tab.NEWS -> News(topics, modifier)
            Tab.ETC -> Etc(ad, modifier)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Home(sampleContacts, sampleChats, sampleTopics, sampleAd)
    }
}