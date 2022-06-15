package ru.lemaitre.bankcomposesample.features.transfers_screen.data.repositories

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.transfers_screen.data.models.TransfersMappers.toDomain
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.repositories.TransferRepository
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.models.AutoTransferModel

class TransferRepositoryImpl(private val storage: Storage) : TransferRepository {
    override suspend fun getAutoTransfers(): List<AutoTransferModel> {
        return storage.getAutoTransfers().map {
            it.toDomain()
        }
    }

}
