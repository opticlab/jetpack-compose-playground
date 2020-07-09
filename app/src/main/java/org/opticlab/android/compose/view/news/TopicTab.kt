package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.selectable
import androidx.ui.layout.RowScope.gravity
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeight
import androidx.ui.layout.wrapContentWidth
import androidx.ui.material.MaterialTheme
import androidx.ui.text.font.FontWeight
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