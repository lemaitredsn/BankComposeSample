package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.Cards
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.MainScreenRepository
import javax.inject.Inject

class CardsUseCase @Inject constructor(
    private val repository: MainScreenRepository
) {
    operator fun invoke() =  flow {
        try {
            emit(StateData.Loading<List<Cards>>())
            val cards = repository.getCardProduct()
            emit(StateData.Success<List<Cards>>(cards))
        }catch (e: Exception){
            emit(
                StateData.Error<List<Cards>>(
                    e.localizedMessage ?: "Произошла ошибка получения данных по продуктам"
                )
            )
        }
    }
}