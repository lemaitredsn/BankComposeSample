package ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.mappers

import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.models.AutoTransferModel
import ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.models.AutoTransfersUI

object MapperTransfersUI {
    fun AutoTransferModel.toUI(): AutoTransfersUI {
        return AutoTransfersUI(
            name = this.title,
            icon = setIcon(this.id),
            id = this.id
        )
    }

    private fun setIcon(id: Long): Int {
        return when (id) {
            0L -> R.drawable.ic_add_note
            else -> R.drawable.ic_note
        }
    }
}