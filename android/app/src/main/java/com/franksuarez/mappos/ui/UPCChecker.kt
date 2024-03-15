package com.franksuarez.mappos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.franksuarez.mappos.ui.theme.MapPOSTheme

@Composable
fun UPCChecker() {
    var upcText by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            //.background(Color.Blue)

    ) {
        Text(

            text = "UPC Validator",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)

        )
        OutlinedTextField(
            value = upcText,
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