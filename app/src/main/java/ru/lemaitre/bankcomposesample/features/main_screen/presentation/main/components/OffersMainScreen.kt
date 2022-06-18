package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.lemaitre.bankcomposesample.common.main.domain.model.Screens
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.OffersItemView
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.MainScreenViewModel

@Composable
fun OffersMainScreen(
    horizontalScrollState : ScrollState,
    viewModel: MainScreenViewModel,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .horizontalScroll(state = horizontalScrollState)
    ) {
        if (viewModel.offersModel.value.isLoading) {
            OffersLoading()
        }
        viewModel.offersModel.value.offers.forEach { offer ->
            OffersItemView(
                offersModel = offer
            ) {
                navController.navigate(Screens.OfferDetail.name + "/${offer.id}")
            }
        }
        if (viewModel.offersModel.value.error.isNotEmpty()) {
            OffersError()
        }
    }
}