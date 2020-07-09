package org.opticlab.android.compose.view.ad

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.WithConstraints
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.VerticalGradient
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ThumbUp
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Ad
import org.opticlab.android.compose.data.sample.sampleAd
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun Advertisement(
    ad: Ad,
    modifier: Modifier = Modifier,
    onClick: (Ad) -> Unit
) {
    Card(modifier = modifier.aspectRatio(2f)) {
        Stack(
            modifier = Modifier.clickable(onClick = { onClick(ad) })
        ) {
            Image(
                asset = Icons.Default.ThumbUp,
                modifier = Modifier.fillMaxSize()
                    .drawBackground(color = MaterialTheme.colors.primaryVariant)
            )
            Text(
                text = "AD",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.gravity(Alignment.TopEnd)
                    .padding(16.dp)
                    .drawBackground(
                        MaterialTheme.colors.surface.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(50)
                    )
                    .drawBorder(1.dp, MaterialTheme.colors.onSurface, RoundedCornerShape(50))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            )
            WithConstraints(
                modifier = Modifier.gravity(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.drawBackground(
                        brush = VerticalGradient(
                            0f to Color.Transparent,
                            1f to Color.Black.copy(alpha = 0.5f),
                            startY = 0f,
                            endY = maxHeight.value
                        )
                    )
                        .padding(16.dp)
                ) {
                    Text(text = ad.title, modifier = Modifier.weight(1f))
                    Text(text = "이동하기")
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        Advertisement(sampleAd) {

        }
    }
}