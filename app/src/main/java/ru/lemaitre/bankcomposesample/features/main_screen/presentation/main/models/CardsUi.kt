package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.Currency
import ru.lemaitre.bankcomposesample.common.domain.PaySystem
import ru.lemaitre.bankcomposesample.common.domain.TypeCard

sealed class CardsUi

data class CardUi(
    val typeCard: TypeCard = TypeCard.SALARY,
    val paySystem: PaySystem = PaySystem.MIR,
    val number: String = "",
    val amount: String = "1523,12",
    val currency: Currency = Currency.RUBLE,
    val status: String? = null,
    @DrawableRes val iconPaySystem: Int,
    @DrawableRes val iconCard: Int = R.drawable.ic_card,
) : CardsUi()

data class OfferCardUI(
    val title: String,
    @DrawableRes val icon: Int = R.drawable.ic_add_card
) : CardsUi()

data class EmptyCardUi(
    val title: String,
    @DrawableRes val icon: Int = R.drawable.ic_not_interested
) : CardsUi()