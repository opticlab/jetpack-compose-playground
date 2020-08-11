package org.opticlab.android.compose.view.common

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun AppBar(title: String, actions: @Composable() RowScope.() -> Unit = {}) {
    TopAppBar(
        title = { Text(text = title) },
        actions = actions
    )
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        AppBar("아몰랑") {
            MenuItem(icon = Icons.Default.Settings) {

            }
        }
    }
}