package ru.lemaitre.bankcomposesample.features.transfers_screen.domain.repositories

import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.models.AutoTransferModel

interface TransferRepository {
    suspend fun getAutoTransfers() : List<AutoTransferModel>
}
