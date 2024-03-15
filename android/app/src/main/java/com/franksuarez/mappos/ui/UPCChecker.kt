package com.franksuarez.mappos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.franksuarez.mappos.ui.theme.MapPOSTheme

@Composable
fun UPCChecker(
    upc: String = "",
    validateOnClick: () -> Unit = {},
    cancelOnClick: () -> Unit = {}



) {
    var upcText by remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = upc,
            onValueChange = {
                upcText = it
            },
            label = {
                Text(
                    text = "UPC"
                )
            }

        )

        Row() {
            Button(
                onClick = {


                },
                modifier = Modifier


            ) {
                Text(
                    text = "Validate"
                )
            }

            Button(
                onClick = {},
                modifier = Modifier

            ) {
                Text(
                    text = "Cancel"
                )
            }

        }
    }


}

@Preview
@Composable
fun UPCCheckerPreview() {
    MapPOSTheme {
        UPCChecker()
    }

}