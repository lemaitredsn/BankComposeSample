package ru.lemaitre.bankcomposesample.features.detail_screen.data

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailModel
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val storage: Storage
): DetailRepository {
    override suspend fun getDetailByProduct(number: String): DetailModel {
        return storage.getHistory(number)
    }
}