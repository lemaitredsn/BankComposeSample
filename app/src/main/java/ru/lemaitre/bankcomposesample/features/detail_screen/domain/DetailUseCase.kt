package ru.lemaitre.bankcomposesample.features.detail_screen.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailRepositoryImpl
import javax.inject.Inject

class DetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    fun getDetails(number: String): Flow<StateData<DetailModel>> = flow {
        try {
            emit(StateData.Loading<DetailModel>())
            emit(StateData.Success<DetailModel>(detailRepository.getDetailByProduct(number)))
        } catch (e: java.lang.Exception) {
            emit(
                StateData.Error<DetailModel>(e.localizedMessage ?: ERROR)
            )
        }
    }

    companion object {
        private const val ERROR = "Произошла ошибка получения детальной информации по продукту"
    }
}

