package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel

interface OfferRepository {
    suspend fun getOffers(): List<OffersModel>
    suspend fun getOffer(title: String): OffersModel?
    suspend fun selectOffer(idOffer: String): ResultModel
}