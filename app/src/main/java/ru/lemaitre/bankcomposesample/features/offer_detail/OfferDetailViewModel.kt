package ru.lemaitre.bankcomposesample.features.offer_detail

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.features.detail_screen.DetailScreenViewModel

class OfferDetailViewModel @AssistedInject constructor(
    @Assisted private val offerId: String
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(offerId: String): OfferDetailViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: OfferDetailViewModel.Factory,
            offerId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(offerId) as T
            }

        }
    }
}

@Composable
fun provideOfferDetailViewModel(offerId: String): OfferDetailViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).offerScreenViewModelFactory()
    return viewModel(factory = OfferDetailViewModel.provideFactory(factory, offerId))
}