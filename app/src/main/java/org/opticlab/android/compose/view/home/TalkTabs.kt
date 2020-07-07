package org.opticlab.android.compose.view.home

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.material.BottomAppBar
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.res.vectorResource
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
                    onSelected = { onTabSelected(tab) })
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