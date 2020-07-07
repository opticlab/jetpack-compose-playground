package org.opticlab.android.compose.view.contact

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Add
import androidx.ui.material.icons.filled.Search
import androidx.ui.material.icons.filled.Settings
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.data.Contact
import org.opticlab.android.compose.data.sample.sampleContacts
import org.opticlab.android.compose.ui.KakaoTheme
import org.opticlab.android.compose.view.common.AppBar
import org.opticlab.android.compose.view.common.MenuItem

@Composable
fun Contacts(
    contacts: List<Contact>,
    modifier: Modifier = Modifier,
    onClickContact: (Contact) -> Unit
) {
    Column(modifier = modifier) {
        AppBar(title = "친구") {
            MenuItem(Icons.Default.Search) {

            }
            MenuItem(Icons.Default.Add) {

            }
            MenuItem(Icons.Default.Settings) {

            }
        }
        LazyColumnItems(items = contacts) { contact ->
            ContactItem(
                contact = contact,
                onClickContact = onClickContact
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    KakaoTheme {
        Contacts(contacts = sampleContacts) {

        }
    }
}