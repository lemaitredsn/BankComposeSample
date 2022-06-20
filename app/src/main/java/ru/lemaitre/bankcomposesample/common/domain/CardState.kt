package ru.lemaitre.bankcomposesample.common.domain

import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.components.AccountsUi


data class CardState(
    val isLoading: Boolean = false,
    val products: List<Cards> = emptyList(),
    val error: String = ""
)

data class AccountState(
    val isLoading: Boolean = false,
    val products: List<AccountsUi> = emptyList(),
    val error: String = ""
)