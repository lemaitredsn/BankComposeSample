package ru.lemaitre.bankcomposesample.features.main_screen.data.repositories

import kotlinx.coroutines.delay
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.common.mappers.MapperDTO.toDomain
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NewProductsDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NameProduct
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NewProductModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NewProductsRepository

class NewProductsRepositoryImpl(
    private val storage: Storage
) : NewProductsRepository {
    override suspend fun getNewProducts(product: NameProduct): List<NewProductModel> {
        return storage.getNewProducts(product.title).map {
            mapper(it)
        }
    }

    override suspend fun sendOrderedProduct(name: String): ResultModel {
        delay(1500)
        return storage.sendOrderedProduct(name).toDomain()
    }

    private fun mapper(dto: NewProductsDTO): NewProductModel {
        return NewProductModel(
            name = dto.name,
            description = dto.description,
            currency = dto.currency,
            term = dto.term,
            condition = dto.condition
        )
    }
}