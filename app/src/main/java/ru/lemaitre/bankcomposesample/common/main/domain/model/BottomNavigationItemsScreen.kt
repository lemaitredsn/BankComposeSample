package ru.lemaitre.bankcomposesample.common.main.domain.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import ru.lemaitre.bankcomposesample.R

sealed class BottomNavigationItemsScreen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Main : BottomNavigationItemsScreen("Главный", R.string.main, Icons.Filled.DateRange)
    object Transfers : BottomNavigationItemsScreen("Переводы", R.string.transfers, Icons.Filled.ArrowDropDown)
    object Yet : BottomNavigationItemsScreen("Еще", R.string.yet, Icons.Filled.Check)
}