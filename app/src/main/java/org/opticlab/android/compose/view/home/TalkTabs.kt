package org.opticlab.android.compose.view.home

import androidx.compose.foundation.Icon
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun TalkTabs(
    selected: Tab,
    onTabSelected: (Tab) -> Unit
) {
    BottomAppBar(
        cutoutShape = CircleShape
    ) {
        BottomNavigation {
            Tab.values().forEach { tab ->
                BottomNavigationItem(
                    icon = { Icon(asset = vectorResource(id = tab.icon)) },
                    selected = selected == tab,
                    onSelect = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        TalkTabs(selected = Tab.CHAT, onTabSelected = {})
    }
}