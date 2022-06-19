package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.common.domain.AccountDomain
import ru.lemaitre.bankcomposesample.common.domain.CardsDomain
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel

interface MainScreenRepository {

    suspend fun getUserName(): String
    suspend fun getCardProduct(): List<CardsDomain>
    suspend fun getOffers(): List<OffersModel>
    suspend fun getAccountProducts(): List<AccountDomain>
}
