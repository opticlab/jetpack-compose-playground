package org.opticlab.android.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import androidx.ui.tooling.preview.PreviewParameterProvider
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.home.Home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KakaoTheme {
                Home(sampleContacts, sampleChats, sampleTopics, sampleAd)
            }
        }
    }
}

class ThemeParameterProvider: PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean> = sequenceOf(false, true)
}

@Preview(showDecoration = true, showBackground = true, group = "Theme")
@Composable
fun Preview(@PreviewParameter(ThemeParameterProvider::class) darkTheme: Boolean) {
    KakaoTheme(darkTheme = darkTheme) {
        Home(sampleContacts, sampleChats, sampleTopics, sampleAd)
    }
}