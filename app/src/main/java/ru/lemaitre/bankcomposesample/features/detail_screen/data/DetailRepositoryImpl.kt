package ru.lemaitre.bankcomposesample.features.detail_screen.data

import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(): DetailRepository {
    override fun getDetailByProduct(number: String): DetailProductDTO {
        return DetailProductDTO()
    }
}