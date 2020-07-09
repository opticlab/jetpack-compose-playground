package org.opticlab.android.compose.view.etc

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Ad
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.ad.Advertisement
import org.opticlab.android.compose.view.common.AppBar

@Composable
fun Etc(ad: Ad, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AppBar(title = "더보기")
        Advertisement(ad = ad, modifier = Modifier.padding(16.dp)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        Etc(sampleAd, modifier = Modifier.fillMaxHeight())
    }
}