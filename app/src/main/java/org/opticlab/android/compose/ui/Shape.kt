package org.opticlab.android.compose.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(0.dp)
)

class SquircleShape : Shape {
    override fun createOutline(size: Size, density: Density): Outline = Outline.Generic(
        Path().apply {
            moveTo(0f, size.height / 2f)
            quadraticBezierTo(0f, 0f, size.width / 2, 0f)
                quadraticBezierTo(size.width, 0f, size.width, size.height / 2)
                quadraticBezierTo(size.width, size.height, size.width / 2, size.height)
                quadraticBezierTo(0f, size.height, 0f, size.height / 2)
        }
    )
}
