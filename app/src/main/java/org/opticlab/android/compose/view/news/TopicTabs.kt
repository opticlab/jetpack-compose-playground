package org.opticlab.android.compose.view.news

import androidx.compose.Composable
import androidx.compose.emptyContent
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.layout.RowScope.gravity
import androidx.ui.layout.preferredHeight
import androidx.ui.material.TabRow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
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

