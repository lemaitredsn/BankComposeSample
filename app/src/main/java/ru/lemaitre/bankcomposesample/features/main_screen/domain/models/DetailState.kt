package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

data class DetailState(
    val isLoading: Boolean = false,
    val details: DetailModel = DetailModel.getDefault(),
    val error: String = ""
)