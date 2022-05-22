package ru.lemaitre.bankcomposesample.features.detail_screen.domain

data class DetailState(
    val isLoading: Boolean = false,
    val details: List<DetailModel> = emptyList(),
    val error: String = ""
)