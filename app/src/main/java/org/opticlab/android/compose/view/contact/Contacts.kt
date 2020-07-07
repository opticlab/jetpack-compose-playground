package org.opticlab.android.compose.view.contact

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.Column
import androidx.ui.tooling.preview.Preview
import org.opticlab.android.compose.R
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
            MenuItem(R.drawable.ic_baseline_search_24) {

            }
            MenuItem(R.drawable.ic_baseline_settings_24) {

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