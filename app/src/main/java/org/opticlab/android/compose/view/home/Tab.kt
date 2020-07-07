package org.opticlab.android.compose.view.home

import androidx.annotation.DrawableRes
import org.opticlab.android.compose.R

enum class Tab(@DrawableRes val icon: Int) {
    CONTACTS(R.drawable.ic_baseline_people_24),
    CHAT(R.drawable.ic_baseline_chat_24),
    NEWS(R.drawable.ic_baseline_dashboard_24),
    ETC(R.drawable.ic_baseline_apps_24)
}