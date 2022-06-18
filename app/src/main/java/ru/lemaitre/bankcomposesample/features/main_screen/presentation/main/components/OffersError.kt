package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun OffersError() {
    val localContext = LocalContext.current
    val dm = localContext.resources.displayMetrics
    val cardWidth = dm.widthPixels / dm.density

    Card(
        modifier = Modifier
            .wrapContentHeight(
                Alignment.CenterVertically
            )
            .width(cardWidth.dp),
        backgroundColor = Color.Red
    ) {
        Text("При загрузке предложений произошла ошибка")
    }
}