package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NameProduct
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NewProductModel

interface NewProductsRepository {
   suspend fun getNewProducts(product: NameProduct): List<NewProductModel>
   suspend fun sendOrderedProduct(name: String): ResultModel
}
