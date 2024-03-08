package com.franksuarez.mappos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.franksuarez.mappos.ui.theme.MapPOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapPOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {



                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPOSApp() {
    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    MapPOSTopBar()
                }

            )


        }


    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {



        }
    }

}

@Composable
fun MapPOSTopBar() {
    Text(
        text = "hi"
    )

}



@Preview
@Composable
fun MapPOSAppPreview() {
    MapPOSTheme {
        MapPOSApp()
    }

}