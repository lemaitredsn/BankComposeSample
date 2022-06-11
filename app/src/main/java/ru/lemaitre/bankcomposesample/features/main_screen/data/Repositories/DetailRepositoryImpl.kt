package ru.lemaitre.bankcomposesample.features.main_screen.data.Repositories

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.DetailModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val storage: Storage
): DetailRepository {
    override suspend fun getDetailByProduct(number: String): DetailModel {
        return storage.getHistory(number)
    }
}