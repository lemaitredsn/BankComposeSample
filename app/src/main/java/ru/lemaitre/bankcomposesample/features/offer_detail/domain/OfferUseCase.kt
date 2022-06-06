package ru.lemaitre.bankcomposesample.features.offer_detail.domain

import ru.lemaitre.bankcomposesample.features.offer_detail.data.OffersRepositoryImpl
import javax.inject.Inject

class OfferUseCase @Inject constructor(
    private val offerRepository: OffersRepositoryImpl
) {
    suspend operator fun invoke(title: String) = requireNotNull(
        offerRepository.getOffer(title)
    )
}