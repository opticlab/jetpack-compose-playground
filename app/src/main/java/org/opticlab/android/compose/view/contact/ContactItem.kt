package org.opticlab.android.compose.view.contact

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.WithConstraints
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.chat.ChatAvatars

@Composable
fun ContactItem(contact: Contact, onClickContact: (Contact) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeightIn(minHeight = 72.dp)
            .clickable(onClick = { onClickContact(contact) })
            .padding(8.dp),
        verticalGravity = Alignment.CenterVertically
    ) {
        ChatAvatars(listOf(contact.avatar), modifier = Modifier.size(56.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = contact.name,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            if (contact.status != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = contact.status,
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        if (contact.media != null) {
            Spacer(modifier = Modifier.width(8.dp))

            WithConstraints {
                ContactMedia(
                    media = contact.media,
                    modifier = Modifier.preferredWidthIn(maxWidth = maxWidth / 2)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        ContactItem(contact = sampleContacts.first(), onClickContact = {})
    }
}