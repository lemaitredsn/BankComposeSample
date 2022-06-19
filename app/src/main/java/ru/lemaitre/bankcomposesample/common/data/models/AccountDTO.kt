package ru.lemaitre.bankcomposesample.common.data.models

data class AccountDTO(
    val typeAccount: String,
    val number: String,
    val amount: String,
    val currency: String,
    val status: String
)