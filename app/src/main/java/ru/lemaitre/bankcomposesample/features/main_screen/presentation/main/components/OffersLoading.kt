package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.lemaitre.bankcomposesample.common.ui.component.ProgressBar

@Composable
fun OffersLoading() {

    val localContext = LocalContext.current
    val dm = localContext.resources.displayMetrics
    val cardWidth = dm.widthPixels / dm.density

    Card(
        modifier = Modifier
            .height(100.dp)
            .width(cardWidth.dp),
        backgroundColor = Color.LightGray
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProgressBar(50)
        }
    }
}