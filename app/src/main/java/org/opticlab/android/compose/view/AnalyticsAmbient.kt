package org.opticlab.android.compose.view

import androidx.compose.runtime.staticAmbientOf
import timber.log.Timber

object Analytics {
    fun event(name: String, vararg keyValues: Pair<String, Any>) {
        Timber.d("Analytics: [$name] ${keyValues.joinToString { (key, value) -> "'$key' = '$value'" }}")
    }
}

val AnalyticsAmbient = staticAmbientOf { Analytics }