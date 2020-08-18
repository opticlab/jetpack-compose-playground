package org.opticlab.android.compose.view.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.github.zsoltk.compose.router.Router
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.chat.Chats
import org.opticlab.android.compose.view.contact.Contacts
import org.opticlab.android.compose.view.etc.Etc
import org.opticlab.android.compose.view.news.News

@Composable
fun Home(
    tabs: List<Tab>,
    defaultRouting: Tab,
) {
    Router(defaultRouting) { backStack ->
        Scaffold(
            bottomBar = {
                TalkTabs(
                    tabs = tabs,
                    selected = backStack.last(),
                    onTabSelected = backStack::push
                )
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding).fillMaxSize()

            when (val tab = backStack.last()) {
                is Tab.Contacts -> Contacts(tab.contacts, modifier) {
                }
                is Tab.Chat -> Chats(tab.chats, modifier) {
                }
                is Tab.News -> News(tab.topics, modifier) {
                }
                is Tab.Etc -> Etc(tab.ad, modifier)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Home(tabs, tabs.first())
    }
}