package ru.lemaitre.bankcomposesample.features.main_screen.data.models

data class NewProductsDTO(
    val name: String = "",
    val description: String = "",
    val currency: String = "",
    val term: String = "4 года",
    val condition: String = ""
)
