package ru.lemaitre.bankcomposesample.common.domain

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel

data class OfferState(
    val isLoading: Boolean = false,
    val offers: List<OffersModel> = emptyList(),
    val error: String = ""
)
