package org.opticlab.android.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.sample.sampleChats
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.data.sample.sampleRecommendedTags
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.home.Home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KakaoTheme {
                Home(sampleContacts, sampleChats, sampleTopics, sampleRecommendedTags)
            }
        }
    }
}

@Preview(showBackground = true, name = "Light theme")
@Composable
fun LightPreview() {
    KakaoTheme(darkTheme = false) {
        Home(sampleContacts, sampleChats, sampleTopics, sampleRecommendedTags)
    }
}

@Preview(showBackground = true, name = "Dark theme")
@Composable
fun DarkPreview() {
    KakaoTheme(darkTheme = true) {
        Home(sampleContacts, sampleChats, sampleTopics, sampleRecommendedTags)
    }
}