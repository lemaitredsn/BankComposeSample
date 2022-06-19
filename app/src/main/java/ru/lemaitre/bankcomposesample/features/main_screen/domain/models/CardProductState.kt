package ru.lemaitre.bankcomposesample.features.main_screen.domain

import ru.lemaitre.bankcomposesample.common.domain.CardsDomain

data class CardState(
    val isLoading: Boolean = false,
    val cards: List<CardsDomain>? = null,
    val error: String = ""
)