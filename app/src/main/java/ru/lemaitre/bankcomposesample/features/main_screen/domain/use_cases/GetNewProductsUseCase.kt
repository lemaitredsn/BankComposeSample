package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NameProduct
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NewProductModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NewProductsRepository
import javax.inject.Inject

class GetNewProductsUseCase @Inject constructor(
    private val repository: NewProductsRepository
) {
    suspend operator fun invoke(productName: NameProduct): List<NewProductModel> {
        return repository.getNewProducts(productName)
    }
}
