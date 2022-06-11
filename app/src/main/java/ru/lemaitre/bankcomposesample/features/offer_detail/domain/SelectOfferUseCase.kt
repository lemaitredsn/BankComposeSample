package ru.lemaitre.bankcomposesample.features.offer_detail.domain

import ru.lemaitre.bankcomposesample.common.data.ResultDTO
import javax.inject.Inject

class SelectOfferUseCase @Inject constructor(
    private val offerRepository: OfferRepository
){
    suspend operator fun invoke(idOffer: String): ResultDTO {
        return offerRepository.selectOffer(idOffer = idOffer)
    }
}