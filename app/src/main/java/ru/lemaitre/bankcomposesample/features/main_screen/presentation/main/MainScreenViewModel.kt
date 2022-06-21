package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.lemaitre.bankcomposesample.common.domain.AccountState
import ru.lemaitre.bankcomposesample.common.domain.CardState
import ru.lemaitre.bankcomposesample.common.domain.OfferState
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.main_screen.domain.MainScreenInteractor
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.AccountUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.CardsUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.mappers.toUi
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val interactor: MainScreenInteractor,
    private val cardsUseCase: CardsUseCase,
    private val accountUseCase: AccountUseCase,
) : ViewModel() {

    private val _userName = mutableStateOf<String>("")
    val userName: State<String> = _userName

    private val _offers = mutableStateOf(OfferState())
    val offersModel: State<OfferState> = _offers

    var isShowCard = mutableStateOf<Boolean>(true)// todo get from shared prefs
    var isShowAccount = mutableStateOf<Boolean>(true)

    private val _cards = mutableStateOf(CardState())
    val cards: State<CardState> = _cards


    private val _accounts = mutableStateOf(AccountState())
    val accounts: State<AccountState> = _accounts

    init {
        getName()
        getOffers()
        showCards(isShowCard.value)
        showAccount(isShowAccount.value)
        loadCards()
        loadAccount()
    }

    private fun getName() {
        viewModelScope.launch {
            val name = interactor.getUserName()
            _userName.value = name
        }
    }

    private fun getOffers() {
        interactor.getOffers().onEach { result ->
            when (result) {
                is StateData.Success -> _offers.value =
                    OfferState(offers = result.data ?: emptyList())
                is StateData.Error -> _offers.value =
                    OfferState(error = result.message ?: "Ошибка получения предложений")
                is StateData.Loading -> _offers.value = OfferState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun loadCards() {
        cardsUseCase().onEach { result ->
            when (result) {
                is StateData.Success -> _cards.value =
                    CardState(products = result.data ?: emptyList())
                is StateData.Error -> _cards.value =
                    CardState(error = result.message ?: "Ошибка получения продуктов")
                is StateData.Loading -> _cards.value = CardState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun loadAccount() {
            accountUseCase().onEach { result ->
                when (result) {
                    is StateData.Success -> _accounts.value =
                        AccountState(products = result.data?.map { it.toUi() } ?: emptyList())
                    is StateData.Error -> _accounts.value =
                        AccountState(error = result.message ?: "Ошибка получения продуктов")
                    is StateData.Loading -> _accounts.value = AccountState(isLoading = true)
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