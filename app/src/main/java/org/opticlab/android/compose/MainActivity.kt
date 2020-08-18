package org.opticlab.android.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.home.Home
import org.opticlab.android.compose.view.home.tabs

class MainActivity : AppCompatActivity() {
    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Providers(
                AmbientBackPressHandler provides backPressHandler
            ) {
                KakaoTheme {
                    Home(tabs, tabs.first())
                }
            }
        }
    }

    override fun onBackPressed() {
        if (backPressHandler.handle().not()) {
            super.onBackPressed()
        }
    }
}