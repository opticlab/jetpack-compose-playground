package org.opticlab.android.compose.view.common

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.material.IconButton

@Composable
fun MenuItem(icon: VectorAsset, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(asset = icon)
    }
}