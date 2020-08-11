package org.opticlab.android.compose.view.news

import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.emptyContent
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Topic
import org.opticlab.android.compose.data.sample.sampleTopics
import org.opticlab.android.compose.ui.KakaoTheme

@Composable
fun TopicTabs(
    topics: List<Topic>,
    selectedTopic: Topic,
    onSelectTopic: (Topic) -> Unit
) {
    TabRow(
        items = topics,
        modifier = Modifier
            .preferredHeight(56.dp)
            .gravity(Alignment.CenterVertically),
        divider = emptyContent(),
        selectedIndex = topics.indexOf(selectedTopic),
        scrollable = true
    ) { _, topic ->
        TopicTab(topic, topic == selectedTopic, onSelectTopic)
    }
}

@Preview
@Composable
private fun Preview() {
    KakaoTheme {
        val (topic, onSelect) = state { sampleTopics.first() }
        TopicTabs(topics = sampleTopics, selectedTopic = topic, onSelectTopic = onSelect)
    }
}

