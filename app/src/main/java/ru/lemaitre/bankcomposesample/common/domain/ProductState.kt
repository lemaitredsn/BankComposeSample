package ru.lemaitre.bankcomposesample.common.domain

data class ProductState(
    val isLoading: Boolean = false,
    val products: List<Products> = emptyList(),
    val error: String = ""
)