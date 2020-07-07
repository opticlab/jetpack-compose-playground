package org.opticlab.android.compose.view.etc

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.common.AppBar

@Composable
fun Etc(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AppBar(title = "더보기")
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        Etc()
    }
}