package org.opticlab.android.compose.view.home

import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.layout.padding
import androidx.ui.layout.preferredSize
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.Scaffold
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.Chat
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.Topic
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
    topics: List<Topic>
) {
    var selected by state { Tab.NEWS }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_baseline_add_24),
                    modifier = Modifier.preferredSize(48.dp)
                )
            }
        },
        floatingActionButtonPosition = Scaffold.FabPosition.Center,
        bottomBar = {
            TalkTabs(
                selected = selected
            ) {
                selected = it
            }
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        when (selected) {
            Tab.CONTACTS -> Contacts(contacts, modifier) {
            }
            Tab.CHAT -> Chats(chats, modifier) {
            }
            Tab.NEWS -> News(topics, modifier)
            Tab.ETC -> Etc(modifier)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Home(sampleContacts, sampleChats, sampleTopics)
    }
}