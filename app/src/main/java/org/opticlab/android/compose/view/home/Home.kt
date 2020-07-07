package org.opticlab.android.compose.view.home

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.padding
import androidx.ui.material.Scaffold
import androidx.ui.savedinstancestate.savedInstanceState
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Chat
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.data.sample.sampleRecommendedTags
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
    recommendedTags: List<String>
) {
    val (selected, onSelect) = savedInstanceState(inputs = *Tab.values()) { Tab.NEWS }

    Scaffold(
        bottomBar = {
            TalkTabs(
                selected = selected,
                onTabSelected = onSelect
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        when (selected) {
            Tab.CONTACTS -> Contacts(contacts, modifier) {
            }
            Tab.CHAT -> Chats(chats, modifier) {
            }
            Tab.NEWS -> News(topics, recommendedTags, modifier)
            Tab.ETC -> Etc(modifier)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Home(sampleContacts, sampleChats, sampleTopics, sampleRecommendedTags)
    }
}