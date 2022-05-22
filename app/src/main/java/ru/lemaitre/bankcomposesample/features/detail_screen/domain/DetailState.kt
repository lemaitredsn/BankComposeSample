package ru.lemaitre.bankcomposesample.features.detail_screen.domain

data class DetailState(
    val isLoading: Boolean = false,
    val details: DetailModel = DetailModel.getDefault(),
    val error: String = ""
)