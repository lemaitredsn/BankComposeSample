package ru.lemaitre.bankcomposesample.features.main_screen.presentation

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import ru.lemaitre.bankcomposesample.common.domain.AccountProductModel
import ru.lemaitre.bankcomposesample.common.domain.CardProductModel
import ru.lemaitre.bankcomposesample.common.domain.Products
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.components.HeaderProducts

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
                OfferView()
            }
            //products
            viewModel.commonProducts.value.products.groupBy {
                it::class.java
            }.map { group ->
                //todo вынести в функции
                val nameResource = when (group.key) {
                    AccountProductModel::class.java -> R.string.main_screen_accounts
                    CardProductModel::class.java -> R.string.main_screen_cards
                    else -> throw IllegalArgumentException("class not find for resource name")
                }
                val rotateCallback = getRotateByType(group.key, viewModel)

                val visibleField = when (group.key) {
                    AccountProductModel::class.java -> viewModel.isShowAccount.value
                    CardProductModel::class.java -> viewModel.isShowCard.value
                    else -> throw IllegalArgumentException("class not find for visible field")
                }
                item {
                    HeaderProducts(
                        nameResource = nameResource,
                        startShow = true,
                        rotatedCallback = rotateCallback
                    )
                }
                items(1) {
                    group.value.forEach { product ->
                        Prod(
                            products = product,
                            visible = visibleField
                        ) {
                            val number = if (product is AccountProductModel) {
                                product.number
                            } else if (product is CardProductModel) {
                                product.number
                            } else {
                                throw IllegalArgumentException("неизвестный продукт")
                            }
                            navController.navigate(Screens.CardDetails.name + "/${number}")
                        }
                    }
                }
            }
        }
    }
}

private fun getRotateByType(
    product: Class<out Products>,
    viewModel: MainScreenViewModel
): (Boolean) -> Unit {
    return when (product) {
        AccountProductModel::class.java -> viewModel::showAccount
        CardProductModel::class.java -> viewModel::showCards
        else -> throw IllegalArgumentException("class not find for rotate callback")
    }
}

