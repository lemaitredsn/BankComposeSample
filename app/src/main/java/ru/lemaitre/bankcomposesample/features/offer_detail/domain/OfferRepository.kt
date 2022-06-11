package ru.lemaitre.bankcomposesample.features.offer_detail.domain

import ru.lemaitre.bankcomposesample.common.data.ResultDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel

interface OfferRepository {
    suspend fun getOffers(): List<OffersModel>
    suspend fun getOffer(title: String): OffersModel?
    suspend fun selectOffer(idOffer: String): ResultDTO
}