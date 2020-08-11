package org.opticlab.android.compose.view.common

import androidx.compose.foundation.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorAsset

@Composable
fun MenuItem(icon: VectorAsset, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(asset = icon)
    }
}
