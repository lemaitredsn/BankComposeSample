package ru.lemaitre.bankcomposesample.features.transfers_screen.data.models

import ru.lemaitre.bankcomposesample.common.data.models.AutoTransferDTO
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.models.AutoTransferModel

object TransfersMappers {
    fun AutoTransferDTO.toDomain(): AutoTransferModel {
        return AutoTransferModel(
            title = this.name,
            id = this.id
        )
    }
}