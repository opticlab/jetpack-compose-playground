package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.RowScope.gravity
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeight
import androidx.ui.layout.preferredWidthIn
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.BaselineShift
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun TopicTab(
    topic: Topic,
    selected: Boolean,
    onSelectTopic: (Topic) -> Unit,
    modifier: Modifier = Modifier
) {
    val title = AnnotatedString.Builder().apply {
        if (selected) {
            pushStyle(
                SpanStyle(
                    baselineShift = BaselineShift.Superscript,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            )
            append("#")
            pop()
        }
        append(topic.title)
    }.toAnnotatedString()

    Tab(
        selected = selected,
        onSelected = { onSelectTopic(topic) },
        modifier = modifier.preferredWidthIn(maxWidth = 120.dp)
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.gravity(Alignment.CenterVertically),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = if (selected) FontWeight.Bold else null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        TopicTab(
            selected = true,
            onSelectTopic = {},
            topic = sampleTopics.first(),
            modifier = Modifier.preferredHeight(56.dp)
        )
    }
}