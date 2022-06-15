package ru.lemaitre.bankcomposesample.features.transfers_screen.domain.use_case

import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.repositories.TransferRepository
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.models.AutoTransferModel
import javax.inject.Inject

class AutoTransfersUseCase @Inject constructor(
    private val transferRepository: TransferRepository
) {

    suspend operator fun invoke(): List<AutoTransferModel>{
        val autoTransfers = transferRepository
            .getAutoTransfers().toMutableList()
        return listOf(CREATE_AUTO_TRANSFER) + autoTransfers
    }

    companion object {
        private val CREATE_AUTO_TRANSFER = AutoTransferModel("Создать автоплатеж", 0L)
    }

}
