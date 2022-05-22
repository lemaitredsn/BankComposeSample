package ru.lemaitre.bankcomposesample.features.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import ru.lemaitre.bankcomposesample.common.main.domain.model.BottomNavigationItemsScreen

@OptIn(ExperimentalAnimationApi::class) //Compose version 1.1.0 and above @ExperimentalAnimationApi not required
@Composable
internal fun AppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationItemsScreen>,
    visibilityState: Boolean
) {
    AnimatedVisibility(visible = visibilityState, content = {
        BottomNavigation() {
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = screen.icon, contentDescription = screen.route) },
                    label = { Text(stringResource(id = screen.resourceId)) },
                    alwaysShowLabel = false,
                    onClick = {
                        when (screen) {
                            is BottomNavigationItemsScreen.Main -> {
                                navController.navigate(
                                    BottomNavigationItemsScreen.Main.route
                                ) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                            is BottomNavigationItemsScreen.Transfers -> navController.navigate(
                                BottomNavigationItemsScreen.Transfers.route
                            ) {
                                popUpTo(BottomNavigationItemsScreen.Main.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            is BottomNavigationItemsScreen.Yet -> navController.navigate(
                                BottomNavigationItemsScreen.Yet.route
                            ) {
                                popUpTo(BottomNavigationItemsScreen.Main.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            else -> Unit
                        }
                    },
                    selected = true
                )
            }
        }
    })
}