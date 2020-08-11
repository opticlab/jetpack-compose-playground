package org.opticlab.android.compose.view.ad

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.VerticalGradient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
                    .background(color = MaterialTheme.colors.primaryVariant)
            )
            Text(
                text = "AD",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.gravity(Alignment.TopEnd)
                    .padding(16.dp)
                    .background(
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
                    modifier = Modifier.background(
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