package ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.mappers

import ru.lemaitre.bankcomposesample.common.domain.Account
import ru.lemaitre.bankcomposesample.common.domain.AccountDomain
import ru.lemaitre.bankcomposesample.common.domain.EmptyAccountModel
import ru.lemaitre.bankcomposesample.common.domain.OfferAccountModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.AccountUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.AccountsUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.EmptyAccountUi
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.OfferAccountUI

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