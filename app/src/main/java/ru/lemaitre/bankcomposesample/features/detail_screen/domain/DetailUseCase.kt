package ru.lemaitre.bankcomposesample.features.detail_screen.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailProductDTO
import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailRepositoryImpl
import javax.inject.Inject

class DetailUseCase @Inject constructor(
    private val detailRepository: DetailRepositoryImpl
) {
    fun getDetails(number: String): Flow<StateData<DetailProductDTO>> = flow {
        try {
            emit(StateData.Loading<DetailProductDTO>())
            val detail = detailRepository.getDetailByProduct(number)
            emit(StateData.Success<DetailProductDTO>(detail))
        } catch (e: Exception) {
            emit(
                StateData.Error<DetailProductDTO>(e.localizedMessage ?: ERROR)
            )
        }
    }

    companion object {
        private const val ERROR = "Произошла ошибка получения детальной информации по продукту"
    }
}

