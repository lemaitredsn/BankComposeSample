package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.mappers

import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.*

fun OfferAccountModel.toUi() = OfferAccountUI(
    title = this.message
)

fun EmptyAccountModel.toUi() = EmptyAccountUi(
    title = this.message
)

fun Account.toUi(): AccountsUi {
    return when (this) {
        is AccountDomain -> this.toUi()
        is OfferAccountModel -> this.toUi()
        is EmptyAccountModel -> this.toUi()
    }
}

fun AccountDomain.toUi() = AccountUi(
    typeAccount = typeAccount,
    number = number,
    amount = amount,
    currency = currency,
    status = status
)

fun OfferCardsModel.toUi() = OfferCardUI(
    title = this.message
)

fun EmptyCardsModel.toUi() = EmptyCardUi(
    title = this.message
)

fun CardsDomain.toUi() = CardUi(
    typeCard = this.typeCard,
    paySystem = this.paySystem,
    number = this.number,
    amount = this.amount,
    currency = this.currency,
    status = this.status,
    iconCard = R.drawable.ic_card, //fixme change this test
    iconPaySystem = this.paySystem.getIcon()
)

fun Cards.toUi(): CardsUi {
    return when (this) {
        is CardsDomain -> this.toUi()
        is OfferCardsModel -> this.toUi()
        is EmptyCardsModel -> this.toUi()
    }
}