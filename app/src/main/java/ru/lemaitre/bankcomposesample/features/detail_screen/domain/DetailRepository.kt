package ru.lemaitre.bankcomposesample.features.detail_screen.domain

import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailProductDTO

interface DetailRepository {
    fun getDetailByProduct(number: String): DetailProductDTO
}