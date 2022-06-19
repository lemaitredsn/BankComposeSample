package ru.lemaitre.bankcomposesample.features.main_screen.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.*
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.OffersModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.MainScreenRepository
import javax.inject.Inject

// FIXME: Исправить на usecases
class MainScreenInteractor @Inject constructor(
    private val repository: MainScreenRepository
) {
    suspend fun getUserName() = repository.getUserName()

    fun getOffers(): Flow<StateData<List<OffersModel>>> = flow{
        try {
            emit(StateData.Loading<List<OffersModel>>())
            delay(5000)
            val offers = repository.getOffers()
            emit(StateData.Success<List<OffersModel>>(offers))
        } catch (e: Exception) {
            emit(
                StateData.Error<List<OffersModel>>(
                    e.localizedMessage ?: "Произошла ошибка получения предложений"
                )
            )
        }
    }
}