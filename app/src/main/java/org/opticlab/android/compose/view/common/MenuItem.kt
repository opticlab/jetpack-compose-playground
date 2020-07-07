package org.opticlab.android.compose.view.common

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.material.IconButton
import androidx.ui.res.vectorResource

@Composable
fun MenuItem(@DrawableRes icon: Int, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            asset = vectorResource(id = icon)
        )
    }
}