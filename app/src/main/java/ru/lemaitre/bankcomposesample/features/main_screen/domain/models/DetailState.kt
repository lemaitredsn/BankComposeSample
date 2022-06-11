package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.DetailModel

data class DetailState(
    val isLoading: Boolean = false,
    val details: DetailModel = DetailModel.getDefault(),
    val error: String = ""
)