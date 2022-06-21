package ru.lemaitre.bankcomposesample.common.domain

import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.AccountsUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.CardsUi


data class CardState(
    val isLoading: Boolean = false,
    val products: List<CardsUi> = emptyList(),
    val error: String = ""
)

data class AccountState(
    val isLoading: Boolean = false,
    val products: List<AccountsUi> = emptyList(),
    val error: String = ""
)