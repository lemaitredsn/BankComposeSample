package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.OfferRepository
import javax.inject.Inject

class SelectOfferUseCase @Inject constructor(
    private val offerRepository: OfferRepository
){
    suspend operator fun invoke(idOffer: String): ResultModel {
        return offerRepository.selectOffer(idOffer = idOffer)
    }
}