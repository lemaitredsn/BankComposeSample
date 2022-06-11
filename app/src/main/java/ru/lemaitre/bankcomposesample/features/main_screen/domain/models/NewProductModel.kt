package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

data class NewProductModel(
    val name: String = "",
    val description: String = "",
    val currency: String = "",
    val term: String = "4 года",
    val condition: String = ""
)