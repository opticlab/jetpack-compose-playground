package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.toStringAsFixed
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.R
import org.opticlab.android.compose.data.NewsFeed
import org.opticlab.android.compose.data.sample.sampleWeather
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun NewsWeather(weather: NewsFeed.Weather, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.preferredHeight(56.dp)
            .fillMaxWidth()
            .clickable(onClick = {})
            .then(modifier)
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