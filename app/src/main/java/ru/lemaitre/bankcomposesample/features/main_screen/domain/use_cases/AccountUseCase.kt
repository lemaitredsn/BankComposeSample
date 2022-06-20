package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.Account
import ru.lemaitre.bankcomposesample.common.domain.Cards
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.MainScreenRepository
import javax.inject.Inject

class AccountUseCase @Inject constructor(
    private val repository: MainScreenRepository
) {
    operator fun invoke() =  flow {
        try {
            emit(StateData.Loading<List<Account>>())
            val accounts = repository.getAccountProducts()
            emit(StateData.Success<List<Account>>(accounts))
        }catch (e: Exception){
            emit(
                StateData.Error<List<Account>>(
                    e.localizedMessage ?: "Произошла ошибка получения данных по продуктам"
                )
            )
        }
    }
}
