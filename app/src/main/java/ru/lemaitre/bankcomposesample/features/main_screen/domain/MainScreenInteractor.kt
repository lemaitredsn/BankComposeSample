package ru.lemaitre.bankcomposesample.features.main_screen.domain

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.lemaitre.bankcomposesample.common.domain.*
import javax.inject.Inject

class MainScreenInteractor @Inject constructor(
    private val repository: MainScreenRepository
) {
    suspend fun getUserName() = repository.getUserName()

    suspend fun getOffers() = repository.getOffers()

    fun getCommonProducts(): Flow<StateData<List<Products>>> = flow {
        try {
            emit(StateData.Loading<List<Products>>())
            val products = mapProducts(repository.getProducts())
            Log.e("TAG", "products ${products.joinToString()}")
            emit(StateData.Success<List<Products>>(products))
        }catch (e: java.lang.Exception){
            emit(
                StateData.Error<List<Products>>(
                    e.localizedMessage ?: "Произошла ошибка получения данных по продуктам"
                )
            )
        }
    }

    private fun mapProducts(list: List<Products>): List<Products> {
        val s = list.sortedBy {
            when (it) {
                is CardProductModel -> 1
                is AccountProductModel -> 2
                is EmptyCardModel -> 3
                is OfferCardModel -> 4
            }
        }

        Log.e("TAG", "sort repository -> $s")
        return s
    }
}