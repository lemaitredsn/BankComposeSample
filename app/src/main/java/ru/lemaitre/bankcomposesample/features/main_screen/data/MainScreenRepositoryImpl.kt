package ru.lemaitre.bankcomposesample.features.main_screen.data

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.common.domain.AccountProductModel
import ru.lemaitre.bankcomposesample.common.domain.CardProductModel
import ru.lemaitre.bankcomposesample.common.domain.Products
import ru.lemaitre.bankcomposesample.features.main_screen.domain.MainScreenRepository
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import javax.inject.Inject
import kotlin.random.Random

class MainScreenRepositoryImpl @Inject constructor(
    private val storage: Storage
) : MainScreenRepository {
    override suspend fun getUserName(): String {
        return "Вячеслав ${Random.nextInt(100)}"
    }

    override suspend fun getCardProduct(): List<CardProductModel> {
        return storage.getCardProduct()
    }

    override suspend fun getOffers(): List<OffersModel> {
        return storage.getOffers()
    }

    override suspend fun getAccountProducts(): List<AccountProductModel> {
        return storage.getAccountProducts()
    }

    override suspend fun getProducts(): List<Products> {
        return storage.getProducts()
    }
}

