package ru.lemaitre.bankcomposesample.features.offer_detail.data

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import ru.lemaitre.bankcomposesample.features.offer_detail.domain.OfferRepository
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val storage: Storage
): OfferRepository {

    override suspend fun getOffers(): List<OffersModel> {
        return emptyList()
    }

    override suspend fun getOffer(title: String): OffersModel? {
        return storage.getOffers().find { it.id.toString() == title }
    }
}