package com.franksuarez.mappos.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.franksuarez.mappos.R
import com.franksuarez.mappos.ui.theme.MapPOSTheme


enum class MapPOSPage(@StringRes val title: Int) {
    Start(title = R.string.start_page_title),
    UpcValidator(title = R.string.upc_validator_page_title),
    Credits(title = R.string.credits_page_title)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPOSApp(
    viewModel: MapPOSViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val currentScreen = MapPOSPage.valueOf(MapPOSPage.Start.name)
    //val e = MapPOSPage.Start
    Scaffold(
        topBar = {
            MapPOSTopBar(
                currentScreen = MapPOSPage.Start
            )
        }


    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)

        ) {
            NavHost(
                navController = navController,
                startDestination = MapPOSPage.Credits.name,
                modifier = Modifier

            ) {

                composable(route = MapPOSPage.Start.name) {
                    Text("start")
                }


                composable(route = MapPOSPage.UpcValidator.name) {
                    Text("validator")
                }

                composable(route = MapPOSPage.Credits.name) {
                    Text("credits")
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPOSTopBar(
    currentScreen: MapPOSPage,
    canNavigateBack: Boolean = true,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier,

    ) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = currentScreen.title)
            )

        }

    )
}



@Preview
@Composable
fun MapPOSAppPreview() {
    MapPOSTheme {
        MapPOSApp()
    }

}