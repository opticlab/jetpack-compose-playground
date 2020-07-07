package org.opticlab.android.compose.ui

import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.geometry.Size
import androidx.ui.graphics.Outline
import androidx.ui.graphics.Path
import androidx.ui.graphics.Shape
import androidx.ui.material.Shapes
import androidx.ui.unit.Density
import androidx.ui.unit.dp

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
