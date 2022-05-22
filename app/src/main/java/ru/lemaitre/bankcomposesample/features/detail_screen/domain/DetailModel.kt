package ru.lemaitre.bankcomposesample.features.detail_screen.domain

import ru.lemaitre.bankcomposesample.common.domain.Products

data class DetailModel(
    val products: Products,
    val historyProduct: List<HistoryItem>
)