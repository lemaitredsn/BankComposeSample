package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components.AccountsComponent
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components.CardsComponent
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components.OffersMainScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val name = viewModel.userName.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name) },
                actions = {
                    IconButton(onClick = { navController.navigate(Screens.Notifications.name) }) {
                        Icon(
                            Icons.Default.Notifications,
                            stringResource(id = R.string.main_screen_notifications)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screens.Profile.name) }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_circle),
                            contentDescription = stringResource(id = R.string.profile)
                        )
                    }
                }
            )
        }
    ) {
        val activity = LocalContext.current as ComponentActivity
        BackHandler {
            activity.finish()
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            //offers
            item {
                val horizontalScrollState = rememberScrollState()
                OffersMainScreen(
                    horizontalScrollState = horizontalScrollState,
                    viewModel = viewModel,
                    navController = navController
                )
            }

            item {
                CardsComponent(
                    rotateCallback = viewModel::showCards,
                    startShow = true, //get from shared
                    cardsUi = viewModel.cards.value.products,
                    navController = navController
                ) {
                    navController.navigate(Screens.CardDetails.name + "/${it}")
                }
            }
            item {
                AccountsComponent(
                    rotateCallback = viewModel::showAccount,
                    startShow = true,
                    accountUi = viewModel.accounts.value.products,
                    navController = navController,
                ) {
                    navController.navigate(Screens.CardDetails.name + "/${it}")
                }
                //todo add products
            }
        }
    }
}


