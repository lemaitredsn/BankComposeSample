package ru.lemaitre.bankcomposesample.common.data.models

enum class TypeCard(
    val title: String,
) {
    SALARY("Зарплатная"),
    CREDIT("Кредитная"),
    DEBIT("Дебетовая")
}