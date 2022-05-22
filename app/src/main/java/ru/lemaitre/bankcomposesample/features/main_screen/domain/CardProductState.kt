package ru.lemaitre.bankcomposesample.features.main_screen.domain

import ru.lemaitre.bankcomposesample.common.domain.CardProductModel

data class CardState(
    val isLoading: Boolean = false,
    val cards: List<CardProductModel>? = null,
    val error: String = ""
)