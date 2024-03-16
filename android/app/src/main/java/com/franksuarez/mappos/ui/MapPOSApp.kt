package com.franksuarez.mappos.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.launch


enum class MapPOSPage(@StringRes val title: Int) {
    Start(title = R.string.start_page_title),
    UpcValidator(title = R.string.upc_validator_page_title),
    Credits(title = R.string.credits_page_title)
}


@Composable
fun MapPOSApp(
    viewModel: MapPOSViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu")
                Divider()
                NavigationDrawerItem(
                    label = { Text("UPC Validator") },
                    selected = false,
                    onClick = {
                        navController.navigate(route = MapPOSPage.UpcValidator.name)
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }


        }) {
        Scaffold(
            topBar = {
                MapPOSTopBar(
                    currentScreen = MapPOSPage.Start,
                    menuOnClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) {
                                    open()
                                } else {
                                    close()
                                }
                            }
                        }
                    }
                )
            }


        ) { paddingValues ->
            ScaffoldContent(paddingValues = paddingValues, navController = navController)
        }
    }

}



@Composable
fun ScaffoldContent(
    paddingValues: PaddingValues,
    navController: NavHostController,

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)

    ) {
        NavHost(
            navController = navController,
            startDestination = MapPOSPage.Start.name,
            modifier = Modifier

        ) {

            composable(route = MapPOSPage.Start.name) {
                Text(
                    stringResource(id = R.string.start_page_title)
                )
            }


            composable(route = MapPOSPage.UpcValidator.name) {
                UPCChecker()
            }

            composable(route = MapPOSPage.Credits.name) {
                Text("credits")
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPOSTopBar(
    currentScreen: MapPOSPage,
    modifier: Modifier = Modifier,
    menuOnClick: () -> Unit = {},


    ) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = stringResource(id = currentScreen.title)
            )

        },
        navigationIcon = {
            IconButton(onClick = menuOnClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }

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