package ru.lemaitre.bankcomposesample.features

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.main.domain.model.BottomNavigationItemsScreen

//Переводы
@Composable
fun TransfersScreen(navController: NavController) {
    val horizontalScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = { /*todo*/ }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "scanner qr"
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*todo*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.qr_code_scanner_black_24dp),
                            "search"
                        )
                    }
                }
            )
        }
    ) {
        val rememberScroll = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(rememberScroll)) {
            Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = "Шаблоны и автоплатежи",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Все",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable {
                            /*todo*/
                        },
                    color = Color.Blue
                )
            }
            Row(
                modifier = Modifier
                    .horizontalScroll(state = horizontalScrollState)
            ) {
                val listAutoTransfer = listOf(
                    AutoTransfer(
                        R.drawable.qr_code_scanner_black_24dp,
                        "Создать шаблон"
                    ),
                    AutoTransfer(
                        R.drawable.mir_icon,
                        "Оплатить по QR"
                    ),
                    AutoTransfer(
                        R.drawable.ic_card,
                        "Капремонт"
                    ),
                    AutoTransfer(
                        R.drawable.ic_menu,
                        "Оплата телефона"
                    ),
                    AutoTransfer(
                        R.drawable.ic_menu,
                        "Газ"
                    ),
                    AutoTransfer(
                        R.drawable.ic_menu,
                        "Оплата воды"
                    )
                )
                listAutoTransfer.forEach {
                    AutoTransfers(autoTransfer = it)
                }
            }
            Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = "Переводы",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
            }
            val listTransfers = listOf(
                TransferItem(
                    R.drawable.mir_icon,
                    "По номеру телефона"
                ),
                TransferItem(
                    R.drawable.union_icon,
                    "По номеру карты"
                ),
                TransferItem(
                    R.drawable.mastercard_icon,
                    "По номеру счета"
                ),
                TransferItem(
                    R.drawable.qr_code_scanner_black_24dp,
                    "Клиенту банка"
                ),
                TransferItem(
                    R.drawable.ic_menu,
                    "Обменять валюту"
                ),
            )
            listTransfers.forEach {
                Transfers(transfer = it)
            }
            Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = "Платежи",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
            }
            val listPayments = listOf(
                TransferItem(
                    R.drawable.mir_icon,
                    "Государственные платежи"
                ),
                TransferItem(
                    R.drawable.union_icon,
                    "Мобильная связь"
                ),
                TransferItem(
                    R.drawable.mastercard_icon,
                    "Коммунадльные платежи"
                ),
                TransferItem(
                    R.drawable.qr_code_scanner_black_24dp,
                    "Образование"
                ),
                TransferItem(
                    R.drawable.ic_menu,
                    "Интернет"
                ),
            )
            listPayments.forEach {
                Transfers(transfer = it)
            }
        }
    }
}

data class TransferItem(
    @DrawableRes val icon: Int,
    val title: String
)

@Composable
fun Transfers(transfer: TransferItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = transfer.icon),
            modifier = Modifier
                .padding(16.dp)
                .width(24.dp)
                .height(24.dp),
            contentDescription = transfer.title
        )
        Text(text = transfer.title)
    }
}

data class AutoTransfer(
    @DrawableRes val icon: Int,
    val title: String
)

@Composable
fun AutoTransfers(
    autoTransfer: AutoTransfer
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
            .height(100.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Icon(
                    painter = painterResource(id = autoTransfer.icon),
                    contentDescription = autoTransfer.title,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Row {
                Text(text = autoTransfer.title)
            }
        }
    }
}

