package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.OfferRepository
import javax.inject.Inject

class OfferUseCase @Inject constructor(
    private val offerRepository: OfferRepository
) {
    suspend operator fun invoke(title: String) = requireNotNull(
        offerRepository.getOffer(title)
    )
}