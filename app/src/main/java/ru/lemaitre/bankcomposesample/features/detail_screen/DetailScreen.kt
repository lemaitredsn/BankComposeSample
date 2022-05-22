package ru.lemaitre.bankcomposesample.features.detail_screen

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
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.HistoryItem

@Composable
fun DetailScreen(viewModel: DetailScreenViewModel) {

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
                            text = "343$",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        )
                    }
                    Row() {
                        Text(
                            text = "1234 4321 5678 8765",
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(2f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = R.drawable.mastercard_icon),
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
            val history = listOf( //todo viewModel state get history
                HistoryItem(123.0, true, "Магазин на районе"),
                HistoryItem(33000.0, false, "Перечисление зп"),
                HistoryItem(1223.0, true, "Магазин мастер спорта"),
                HistoryItem(3121.0, true, "Магазин самнеси"),
            )
            history.forEach {
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