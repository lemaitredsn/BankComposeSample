package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NewProductsRepository
import javax.inject.Inject

class SendOrderedProductUseCase @Inject constructor(
    private val repository: NewProductsRepository
) {
    suspend operator fun invoke(nameString: String): ResultModel {
        return repository.sendOrderedProduct(nameString)
    }
}
