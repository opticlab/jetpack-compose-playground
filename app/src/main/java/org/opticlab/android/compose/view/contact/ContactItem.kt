package org.opticlab.android.compose.view.contact

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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