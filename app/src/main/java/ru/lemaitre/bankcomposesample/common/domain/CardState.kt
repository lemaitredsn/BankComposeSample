package ru.lemaitre.bankcomposesample.common.domain


data class CardState(
    val isLoading: Boolean = false,
    val products: List<Cards> = emptyList(),
    val error: String = ""
)

data class AccountState(
    val isLoading: Boolean = false,
    val products: List<Account> = emptyList(),
    val error: String = ""
)