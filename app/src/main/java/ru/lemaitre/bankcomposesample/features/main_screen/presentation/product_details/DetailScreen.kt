package ru.lemaitre.bankcomposesample.features.main_screen.presentation.product_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.HistoryItem

@Composable
fun DetailScreen(viewModel: DetailScreenViewModel) {
    if (viewModel.detailProduct.value.isLoading) {
        Text(text = "Загрузка")
    }
    if (viewModel.detailProduct.value.error != null) {
        Text(text = "Ошибка")
    }
    Column() {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        text = "Банк", modifier = Modifier
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row() {
                        Text(
                            text = "${viewModel.detailProduct.value.details.sum}$",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        )
                    }
                    Row() {
                        Text(
                            text = viewModel.detailProduct.value.details.number ?: "",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(2f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(
//                                id = viewModel.detailProduct.value.details.icon
                                R.drawable.ic_card
                            ),
                            contentDescription = "drawable",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(20.dp)
                                .clip(CircleShape)
                                .weight(1f)
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .weight(3f)
                .fillMaxWidth()
        ) {
            viewModel.detailProduct.value.details.historyProduct.forEach {
                HistoryItemView(history = it)
            }
        }
    }
}

@Composable
fun HistoryItemView(history: HistoryItem) {
    val drawable = if (history.isCredit) {
        R.drawable.ic_remove_red
    } else {
        R.drawable.ic_add_green
    }
    Box(contentAlignment = Alignment.Center) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = "sign",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = history.sum.toString(), modifier = Modifier
                        .padding(4.dp)
                        .weight(9f)
                )
            }
            Text(text = history.description)
        }
    }
}