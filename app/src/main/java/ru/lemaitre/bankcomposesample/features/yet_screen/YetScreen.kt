package ru.lemaitre.bankcomposesample.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.TransferItem
import ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.Transfers

//Еще
@Composable
fun YetScreen(navController: NavController) {

    Scaffold {
        val rememberScroll = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(rememberScroll)) {
            Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.yet_settings),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
            }
            val listTransfers = listOf(
                TransferItem(
                    R.drawable.mir_icon,
                    "Настройки"
                ),
                TransferItem(
                    R.drawable.union_icon,
                    "Выписки"
                ),
                TransferItem(
                    R.drawable.mastercard_icon,
                    "Офисы и банкоматы"
                ),
                TransferItem(
                    R.drawable.qr_code_scanner_black_24dp,
                    "Обратиться в банк"
                ),
                TransferItem(
                    R.drawable.ic_menu,
                    "Выйти"
                ),
            )
            listTransfers.forEach {
                Transfers(transfer = it)
            }
        }
    }
}