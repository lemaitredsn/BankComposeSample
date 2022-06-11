package ru.lemaitre.bankcomposesample.features.offer_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.lemaitre.bankcomposesample.features.offer_detail.presentation.OfferDetailViewModel

@Composable
fun OfferDetailScreen(viewModel: OfferDetailViewModel) {
    val model = viewModel.offer.value
    if (viewModel.loading.value) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = Color.Black,
                strokeWidth = 10.dp
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    model.backgroundColor
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = requireNotNull(model.icon)),
                    contentDescription = model.title,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = model.title,
                        fontSize = 24.sp
                    )
                    Text(
                        text = model.description,
                        style = TextStyle(textAlign = TextAlign.Justify)
                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = { viewModel.wantToGetClicked() }) {
                Text(text = "Хочу получить")
            }
        }

        if (viewModel.result.value.isNotEmpty()) {
            AlertDialog(
                onDismissRequest = { viewModel.closeDialog() },
                title = { Text(text = viewModel.result.value) },
                buttons = {
                    Button(
                        onClick = { viewModel.closeDialog() }
                    ) {
                        Text("OK", fontSize = 22.sp)
                    }
                }
            )
        }
    }
}