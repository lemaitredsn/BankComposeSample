package ru.lemaitre.bankcomposesample.features.offer_detail.domain

import javax.inject.Inject

class OfferUseCase @Inject constructor(
    private val offerRepository: OfferRepository
) {
    suspend operator fun invoke(title: String) = requireNotNull(
        offerRepository.getOffer(title)
    )
}