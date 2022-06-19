package ru.lemaitre.bankcomposesample.common.domain

data class ProductState(
    val isLoading: Boolean = false,
    val products: List<Cards> = emptyList(),
    val error: String = ""
)