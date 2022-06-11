package ru.lemaitre.bankcomposesample.common.mappers

import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.ResultModel
import ru.lemaitre.bankcomposesample.common.ui.models.ResultUI

object MapperUI {
    fun ResultUI.toDomain(): ResultModel {
        return ResultModel(
            status = this.status,
            message = this.message
        )
    }

    fun ResultModel.toUI(): ResultUI {
        return ResultUI(
            status = this.status,
            message = this.message,
            icon = getIconByResult(this.status)
        )
    }

    private fun getIconByResult(result: String): Int {
        return when (result) {
            ERROR -> R.drawable.ic_error
            SUCCESS -> R.drawable.ic_success
            else -> R.drawable.ic_error
        }
    }

    private const val ERROR = "Ошибка"
    private const val SUCCESS = "Успех"
}