package ru.lemaitre.bankcomposesample.features.offer_detail.domain

import ru.lemaitre.bankcomposesample.common.data.ResultDTO
import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import javax.inject.Inject

class SelectOfferUseCase @Inject constructor(
    private val offerRepository: OfferRepository
){
    suspend operator fun invoke(idOffer: String): ResultModel {
        return offerRepository.selectOffer(idOffer = idOffer)
    }
}