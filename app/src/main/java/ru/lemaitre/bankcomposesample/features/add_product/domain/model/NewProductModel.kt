package ru.lemaitre.bankcomposesample.features.add_product.domain.model

data class NewProductModel(
    val name: String = "",
    val description: String = "",
    val currency: String = "",
    val term: String = "4 года",
    val condition: String = ""
)