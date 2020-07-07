package org.opticlab.android.compose.view.common

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.layout.RowScope
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Settings
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