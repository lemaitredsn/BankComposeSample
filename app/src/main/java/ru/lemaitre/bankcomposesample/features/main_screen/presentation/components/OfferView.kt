package ru.lemaitre.bankcomposesample.features.main_screen.presentation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OfferView(viewModel: MainScreenViewModel = hiltViewModel()) {
    val horizontalScrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(state = horizontalScrollState)
    ) {
        viewModel.offersModel.value.forEach {
            OffersItemView(offersModel = it)
        }
    }
}