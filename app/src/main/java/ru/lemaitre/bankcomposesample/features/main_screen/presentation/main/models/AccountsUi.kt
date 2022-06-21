package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.Currency
import ru.lemaitre.bankcomposesample.common.domain.TypeAccount

sealed class AccountsUi

data class AccountUi(
    val typeAccount: TypeAccount,
    val number: String = "",
    val amount: String = "1523,12",
    val currency: Currency = Currency.RUBLE,
    val status: String? = null,
    @DrawableRes val iconAccount: Int = R.drawable.ic_card,
) : AccountsUi()

data class OfferAccountUI(
    val title: String,
    @DrawableRes val icon: Int = R.drawable.ic_add_card
) : AccountsUi()

data class EmptyAccountUi(
    val title: String,
    @DrawableRes val icon: Int = R.drawable.ic_not_interested
) : AccountsUi()