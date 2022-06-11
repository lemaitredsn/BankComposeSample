package ru.lemaitre.bankcomposesample.features.offer_detail.data

import kotlinx.coroutines.delay
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.common.mappers.MapperDTO.toDomain
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import ru.lemaitre.bankcomposesample.features.offer_detail.domain.OfferRepository
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(
    private val storage: Storage
) : OfferRepository {

    override suspend fun getOffers(): List<OffersModel> {
        return emptyList()
    }

    override suspend fun getOffer(title: String): OffersModel? {
        return storage.getOffers().find { it.id.toString() == title }
    }

    override suspend fun selectOffer(idOffer: String): ResultModel {
        delay(1500)
        return storage.sendOffer(idOffer = idOffer).toDomain()
    }
}