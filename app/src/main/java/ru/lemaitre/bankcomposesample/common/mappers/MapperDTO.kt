package ru.lemaitre.bankcomposesample.common.mappers

import ru.lemaitre.bankcomposesample.common.data.ResultDTO
import ru.lemaitre.bankcomposesample.common.domain.ResultModel

object MapperDTO {
    fun ResultDTO.toDomain(): ResultModel {
        return ResultModel(
            status = this.status,
            message = this.message
        )
    }
}