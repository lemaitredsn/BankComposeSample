package ru.lemaitre.bankcomposesample.common.domain

import ru.lemaitre.bankcomposesample.R

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
    DEBIT("Дебетовая");

    companion object {
        fun fromString(typeCard: String) : TypeCard {
            return TypeCard.values().first { it.title == typeCard }
        }
    }
}

enum class PaySystem(val title: String) {
    MIR("Мир"),
    MASTER_CARD("Master Card"),
    VISA("Visa"),
    UNION_PAY("Union pay");
    companion object {
        fun fromString(paySystem: String) : PaySystem {
            return PaySystem.values().first { it.title == paySystem }
        }
    }
}

//fixme to UI mapper
fun PaySystem.getIcon(): Int {
    return when (this) {
        PaySystem.MIR -> R.drawable.mir_icon
        PaySystem.MASTER_CARD -> R.drawable.mastercard_icon
        PaySystem.VISA -> R.drawable.visa_icon
        PaySystem.UNION_PAY -> R.drawable.union_icon
    }
}

enum class TypeAccount(
    val title: String
) {
    SALARY("Зарплатный"),
    CREDIT("Кредитный"),
    CURRENT("Дебетовый"),
    SAVINGS("Накопительный"),
    INVEST("Инвестиционный");

    companion object {
        fun fromString(typeAccount: String) : TypeAccount {
            return values().first { it.title == typeAccount }
        }
    }
}

//fixme to UI mapper
private fun TypeAccount.getIcon(): Int {
    return when (this) {
        TypeAccount.SALARY -> R.drawable.ic_card
        TypeAccount.CREDIT -> R.drawable.ic_card
        TypeAccount.CURRENT -> R.drawable.ic_card
        TypeAccount.SAVINGS -> R.drawable.ic_card
        TypeAccount.INVEST -> R.drawable.ic_card
    }
}

enum class Currency(val title: String, val character: String) {
    RUBLE("Рубль", "₽"),
    DOLLAR("Доллар", "$"),
    EURO("Евро", "€");

    companion object {
        fun fromString(currency: String) : Currency {
            return Currency.values().first { it.title == currency }
        }
    }
}

sealed class Account

data class AccountDomain(
    val typeAccount: TypeAccount = TypeAccount.CURRENT,
    val number: String = "",
    val amount: String,
    val currency: Currency = Currency.RUBLE,
    val status: String?
): Account()

sealed class Cards

data class CardsDomain(
    val typeCard: TypeCard = TypeCard.SALARY,
    val paySystem: PaySystem = PaySystem.MIR,
    val number: String = "",
    val amount: String = "1523,12",
    val currency: Currency = Currency.RUBLE,
    val status: String? = null
) : Cards()

data class EmptyCardsModel(
    val message: String = "Пока у вас нет карт"
): Cards()

data class OfferCardsModel(
    val message: String = "Персональное предложение по карте"
): Cards()