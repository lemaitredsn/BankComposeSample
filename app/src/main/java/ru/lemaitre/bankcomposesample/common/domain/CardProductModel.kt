package ru.lemaitre.bankcomposesample.common.domain

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R

sealed class Products()

/*
* счета накопительный, зарплатный, текущий, кредитный
* карты зарплатная, дебетовая, кредитная
* вклады 3 продукта долгий, успешный, накопительный
*
* */


enum class TypeCard(
    val title: String,
) {
    SALARY("Зарплатная"),
    CREDIT("Кредитная"),
    DEBIT("Дебетовая")
}

enum class PaySystem(val title: String, @DrawableRes val icon: Int) {
    MIR("Мир", R.drawable.mir_icon),
    MASTER_CARD("Master Card", R.drawable.mastercard_icon),
    VISA("Visa", R.drawable.visa_icon),
    UNION_PAY("Union pay", R.drawable.union_icon)
}

enum class TypeAccount(
    val title: String, @DrawableRes val icon: Int
) {
    SALARY("Зарплатный", R.drawable.ic_card),
    CREDIT("Кредитный", R.drawable.ic_card),
    CURRENT("Дебетовый", R.drawable.ic_card),
    SAVINGS("Накопительный", R.drawable.ic_card),
    INVEST("Инвестиционный", R.drawable.ic_card)
}

enum class Currency(val title: String, val character: String) {
    RUBLE("Рубль", "₽"),
    DOLLAR("Доллар", "$"),
    EURO("Евро", "€")
}

data class AccountProductModel(
    val typeAccount: TypeAccount = TypeAccount.CURRENT,
    val userNameAccount: String = typeAccount.title,
    val number: String = "",
    val amount: String = "",
    val currency: Currency = Currency.RUBLE,
    val status: String?,
    val list: List<CardProductModel>? = null
) : Products()

data class CardProductModel(
    val typeCard: TypeCard = TypeCard.SALARY,
    val userNameCard: String = typeCard.title,
    val paySystem: PaySystem = PaySystem.MIR,
    val endNumber: String = "4325",
    val number: String = "",
    val amount: String = "1523,12",
    val currency: Currency = Currency.RUBLE,
    val status: String? = null
) : Products()

data class EmptyCardModel(
    val message: String = "Пока у вас нет карт"
) : Products()

data class OfferCardModel(
    val message: String = "Персональное предложение по карте"
) : Products()