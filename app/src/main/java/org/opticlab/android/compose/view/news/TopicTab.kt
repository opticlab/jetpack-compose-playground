package org.opticlab.android.compose.view.news

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
    val title = if (selected) {
        "#${topic.title}"
    } else {
        topic.title
    }

    Box(
        modifier = modifier
            .selectable(selected = selected, onClick = { onSelectTopic(topic) })
            .fillMaxHeight()
            .wrapContentWidth(),
        gravity = ContentGravity.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.gravity(Alignment.CenterVertically)
                .padding(8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
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