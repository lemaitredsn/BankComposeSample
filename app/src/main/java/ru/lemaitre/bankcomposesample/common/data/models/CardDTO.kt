package ru.lemaitre.bankcomposesample.common.data.models

data class CardDTO(
    val number: String,
    val typeCard: String, //Зарплатная, Кредитная, Дебетовая
    val paySystem: String, //Мир, Master Card, Visa, Union pay
    val amount: String,
    val currency: String, // Доллар, Рубль, Евро
    val status: String = ""
)
