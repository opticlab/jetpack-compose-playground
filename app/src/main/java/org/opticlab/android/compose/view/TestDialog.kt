package org.opticlab.android.compose.view

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.ui.foundation.Text
import androidx.ui.material.AlertDialog
import androidx.ui.material.AlertDialogButtonLayout
import androidx.ui.material.TextButton

@Composable
fun TestDialog(show: MutableState<Boolean>) {
    if (show.value) {
        AlertDialog(
            onCloseRequest = {
                show.value = false
            },
            title = {
                Text(text = "Hello!")
            },
            text = {
                Text(text = "World!")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        show.value = false
                    },
                    text = {
                        Text(text = "Confirm")
                    }
                )
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        show.value = false
                    },
                    text = {
                        Text(text = "Dismiss")
                    }
                )
            },
            buttonLayout = AlertDialogButtonLayout.Stacked
        )
    }
}