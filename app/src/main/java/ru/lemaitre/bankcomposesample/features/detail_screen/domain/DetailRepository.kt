package ru.lemaitre.bankcomposesample.features.detail_screen.domain

interface DetailRepository {
    suspend fun getDetailByProduct(number: String): DetailModel
}