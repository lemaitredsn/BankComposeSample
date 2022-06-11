package ru.lemaitre.bankcomposesample.features.main_screen.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.lemaitre.bankcomposesample.common.domain.ProductState
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.main_screen.domain.MainScreenInteractor
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val interactor: MainScreenInteractor
) : ViewModel() {

    private val _userName = mutableStateOf<String>("")
    val userName: State<String> = _userName

    private val _offers = mutableStateOf<List<OffersModel>>(emptyList())
    val offersModel: State<List<OffersModel>> = _offers

    var isShowCard = mutableStateOf<Boolean>(true)// todo get from shared prefs
    var isShowAccount = mutableStateOf<Boolean>(true)

    //todo сделать через state как _state
    private val _commonProducts = mutableStateOf(ProductState())
    val commonProducts: State<ProductState> = _commonProducts

    init {
        getName()
        getOffers()
        showCards(isShowCard.value)
        showAccount(isShowAccount.value)
        commonProducts()
    }

    private fun getName() {
        viewModelScope.launch {
            val name = interactor.getUserName()
            _userName.value = name
        }
    }

    private fun getOffers() {
        viewModelScope.launch {
            delay(1000)
            _offers.value = interactor.getOffers()
        }
    }

    fun commonProducts() {
        interactor.getCommonProducts().onEach { result ->
            when (result) {
                is StateData.Success -> _commonProducts.value =
                    ProductState(products = result.data ?: emptyList())
                is StateData.Error -> _commonProducts.value =
                    ProductState(error = result.message ?: "Ошибка получения продуктов")
                is StateData.Loading -> _commonProducts.value = ProductState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun showAccount(boolean: Boolean) {
        isShowAccount.value = boolean
    }

    fun showCards(boolean: Boolean) {
        isShowCard.value = boolean
    }

}