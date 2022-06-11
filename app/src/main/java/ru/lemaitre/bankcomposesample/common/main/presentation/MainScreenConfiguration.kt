package ru.lemaitre.bankcomposesample.features

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.lemaitre.bankcomposesample.common.main.domain.model.BottomNavigationItemsScreen
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.features.add_product.presentation.NewProductScreen
import ru.lemaitre.bankcomposesample.features.main.AppBottomNavigation
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.product_details.DetailScreen
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.product_details.provideDetailScreenViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.MainScreen
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.new_product.provideNewProductViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications.NotificationsScreen
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications_details.NotificationsDetailsScreen
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications_details.provideNotificationsDetailsViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.offer_details.provideOfferDetailViewModel
import ru.lemaitre.bankcomposesample.features.offer_detail.OfferDetailScreen

@Preview
@Composable
fun MainScreenConfiguration() {

    val bottomNavigationItems = listOf(
        BottomNavigationItemsScreen.Main,
        BottomNavigationItemsScreen.Transfers,
        BottomNavigationItemsScreen.Yet,
    )

    val navController = rememberNavController()

    val scope = rememberCoroutineScope()

    // State of bottomBar, set state to false, if current page route is "main"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination?.route
    when (destination) {
        BottomNavigationItemsScreen.Main.route,
        BottomNavigationItemsScreen.Transfers.route,
        BottomNavigationItemsScreen.Yet.route -> {
            // Show BottomBar and TopBar
            bottomBarState.value = true
//            topBarState.value = true //todo
        }
        else -> {
            bottomBarState.value = false
        }
    }

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,

        bottomBar = {
            AppBottomNavigation(
                navController = navController,
                items = bottomNavigationItems,
                visibilityState = bottomBarState.value
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItemsScreen.Main.route
        ) {
            composable(BottomNavigationItemsScreen.Main.route) { MainScreen(navController) }
            composable(BottomNavigationItemsScreen.Transfers.route) { TransfersScreen(navController) }
            composable(BottomNavigationItemsScreen.Yet.route) { YetScreen(navController) }
            composable(Screens.Profile.name) { ProfileScreen() }
            composable(Screens.Notifications.name) { NotificationsScreen(navController) }
            composable(route = Screens.CardDetails.name + "/{product}",
                arguments = listOf(
                    navArgument("product") {
                        type = NavType.StringType
                        nullable = false

                    }
                )
            ) { entry ->
                DetailScreen(
                    viewModel = provideDetailScreenViewModel(
                        entry.arguments?.getString("product") //fixme move to constants
                            ?: throw IllegalArgumentException("DetailScreenTest: product not be null ")
                    )
                )
            }
            composable(
                route = Screens.OfferDetail.name + "/{offerId}",
                arguments = listOf(
                    navArgument("offerId") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) { entry ->
                OfferDetailScreen(
                    viewModel = provideOfferDetailViewModel(
                        entry.arguments?.getString("offerId")
                            ?: throw IllegalArgumentException("Offer detail screen: offer id not be null")
                    )
                )
            }
            composable(
                route = Screens.NewProduct.name + "/{product}",
                arguments = listOf(
                    navArgument("product") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) { entry ->
                NewProductScreen(
                    viewModel = provideNewProductViewModel(
                        product = requireNotNull(entry.arguments?.getString("product"))
                    )
                )
            }
            composable(
                route = Screens.NotificationDetails.name + "/{notificationId}",
                arguments = listOf(
                    navArgument("notificationId") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) { entry ->
                NotificationsDetailsScreen(
                    viewModel = provideNotificationsDetailsViewModel(
                        notificationId = requireNotNull(entry.arguments?.getString("notificationId"))
                    )
                )
            }
        }
    }
}


