package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.style.BaselineShift
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.util.toStringAsFixed
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.sample.sampleWeather
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsWeather(weather: NewsFeed.Weather, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.preferredHeight(56.dp)
            .fillMaxWidth()
            .clickable(onClick = {}) + modifier
    ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(
                asset = vectorResource(id = R.drawable.ic_baseline_music_note_24),
                modifier = Modifier.preferredSize(48.dp)
                    .gravity(Alignment.CenterVertically),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = AnnotatedString.Builder(weather.weather.temperature.toStringAsFixed(1))
                    .apply {
                        pushStyle(
                            SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                                fontSize = MaterialTheme.typography.caption.fontSize
                            )
                        )
                        append("℃")
                        pop()
                    }
                    .toAnnotatedString(),
                modifier = Modifier.gravity(Alignment.CenterVertically),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = weather.weather.region,
                modifier = Modifier.weight(1f).gravity(Alignment.CenterVertically),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = {}, modifier = Modifier.gravity(Alignment.CenterVertically)) {
                Icon(asset = vectorResource(id = R.drawable.ic_baseline_my_location_24))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        NewsWeather(weather = sampleWeather)
    }
}