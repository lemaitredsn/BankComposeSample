package ru.lemaitre.bankcomposesample.features.main_screen.domain

import ru.lemaitre.bankcomposesample.common.domain.AccountProductModel
import ru.lemaitre.bankcomposesample.common.domain.CardProductModel
import ru.lemaitre.bankcomposesample.common.domain.Products

interface MainScreenRepository {

    suspend fun getUserName(): String
    suspend fun getCardProduct(): List<CardProductModel>
    suspend fun getOffers(): List<OffersModel>
    suspend fun getAccountProducts(): List<AccountProductModel>
    suspend fun getProducts(): List<Products>
}
