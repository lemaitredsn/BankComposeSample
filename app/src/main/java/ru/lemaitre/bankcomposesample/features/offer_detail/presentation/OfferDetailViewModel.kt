package ru.lemaitre.bankcomposesample.features.offer_detail.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.features.detail_screen.DetailScreenViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import ru.lemaitre.bankcomposesample.features.offer_detail.domain.OfferUseCase
import ru.lemaitre.bankcomposesample.features.offer_detail.domain.SelectOfferUseCase

class OfferDetailViewModel @AssistedInject constructor(
    @Assisted private val offerId: String,
    private val offerUseCase: OfferUseCase,
    private val selectOfferUseCase: SelectOfferUseCase
): ViewModel() {

    private val _offer = mutableStateOf(OffersModel())
    val offer: State<OffersModel> = _offer

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    private val _result = mutableStateOf("")
    val result: State<String> = _result

    init {
        getOffer()
    }

    fun getOffer(){
        viewModelScope.launch {
            Log.e("TAG", "offerId $offerId")
            _offer.value = offerUseCase(offerId)
        }
    }

    fun wantToGetClicked() {
        viewModelScope.launch {
            _loading.value = true
            val result = selectOfferUseCase(offerId)
            _result.value = result.status.name
            _loading.value = false
        }
    }

    fun closeDialog(){
        _result.value = ""
    }

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
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).offerScreenViewModelFactory()
    return viewModel(factory = OfferDetailViewModel.provideFactory(factory, offerId))
}