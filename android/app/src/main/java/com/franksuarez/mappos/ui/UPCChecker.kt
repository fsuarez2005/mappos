package com.franksuarez.mappos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.franksuarez.mappos.R
import com.franksuarez.mappos.ui.theme.MapPOSTheme

@Composable
fun UPCChecker(
    isValid: Boolean = true,
    showValidStatus: Boolean = false,
    validateOnClick: (upc: String) -> Unit = {},
    cancelOnClick: () -> Unit = {}


) {

    var upc by remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = upc,
            onValueChange = {
                upc = it
            },
            label = {
                Text(
                    text = "UPC"
                )
            }

        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Row() {
            Button(
                onClick = { validateOnClick(upc) },
                modifier = Modifier


            ) {

                // Validation text
                Text(
                    text = stringResource(R.string.validate)
                )
            }
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            Button(
                onClick = cancelOnClick,


            ) {
                Text(
                    text = stringResource(id = R.string.cancel)
                )
            }

        }
        if (showValidStatus) {
            if (isValid) {
                Text(
                    text = "UPC is valid."
                )
            } else {
                Text(
                    text = "UPC is invalid."
                )
            }


        }
    }


}

@Preview
@Composable
fun UPCCheckerPreview() {
    MapPOSTheme {
        UPCChecker(
            showValidStatus = true,
            isValid = false
        )
    }

}