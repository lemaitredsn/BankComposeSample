package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.DetailModel

interface DetailRepository {
    suspend fun getDetailByProduct(number: String): DetailModel
}