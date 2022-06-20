package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

import ru.lemaitre.bankcomposesample.common.domain.Currency

data class DetailModel(
    val sum: String,
    val number: String,
    val currency: Currency = Currency.RUBLE,
    val historyProduct: List<HistoryItem>
){
    companion object{
        fun getDefault() = DetailModel("-1.0","3", Currency.RUBLE,emptyList())
    }
}