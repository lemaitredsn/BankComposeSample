package ru.lemaitre.bankcomposesample.features.main_screen.data.repositories

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.common.data.models.AccountDTO
import ru.lemaitre.bankcomposesample.common.data.models.CardDTO
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.MainScreenRepository
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel
import javax.inject.Inject
import kotlin.random.Random

class MainScreenRepositoryImpl @Inject constructor(
    private val storage: Storage
) : MainScreenRepository {
    override suspend fun getUserName(): String {
        return "Вячеслав ${Random.nextInt(100)}"
    }

    override suspend fun getCardProduct(): List<CardsDomain> {
        return storage.getCardProduct().map {
            it.toDomain()
        }
    }

    //fixme to mapper
    fun CardDTO.toDomain(): CardsDomain {
        return CardsDomain(
            typeCard = TypeCard.fromString(this.typeCard),
            paySystem = PaySystem.fromString(this.paySystem),
            number = number,
            amount = amount,
            currency = Currency.fromString(this.currency),
            status = this.status
        )
    }

    override suspend fun getOffers(): List<OffersModel> {
        return storage.getOffers()
    }

    override suspend fun getAccountProducts(): List<AccountDomain> {
        return storage.getAccountProducts().map {
            it.toDomain()
        }
    }
    //fixme to mapper
    private fun AccountDTO.toDomain(): AccountDomain {
        return AccountDomain(
            typeAccount = TypeAccount.fromString(this.typeAccount),
            number = this.number,
            amount = this.amount,
            currency = Currency.fromString(this.currency),
            status = this.status
        )
    }
}

