package ru.lemaitre.bankcomposesample.common.main.domain.model

import androidx.annotation.DrawableRes
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
    @DrawableRes val icon: Int
) {
    object Main : BottomNavigationItemsScreen("Главный", R.string.main, R.drawable.ic_star)
    object Transfers : BottomNavigationItemsScreen("Переводы", R.string.transfers, R.drawable.ic_money)
    object Yet : BottomNavigationItemsScreen("Еще", R.string.yet, R.drawable.ic_settings)
}