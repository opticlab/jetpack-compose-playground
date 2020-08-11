package org.opticlab.android.compose.view.etc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandlerAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Ad
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.AnalyticsAmbient
import org.opticlab.android.compose.view.ad.Advertisement
import org.opticlab.android.compose.view.common.AppBar

@Composable
fun Etc(ad: Ad, modifier: Modifier = Modifier) {
    val analytics = AnalyticsAmbient.current
    val uriHandler = UriHandlerAmbient.current

    Column(modifier = modifier) {
        AppBar(title = "더보기")
        Column(modifier = Modifier.padding(16.dp)) {
            Advertisement(ad = ad) { ad ->
                uriHandler.openUri(ad.url)
                analytics.event("Etc AD", "uri" to ad.url)
            }
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