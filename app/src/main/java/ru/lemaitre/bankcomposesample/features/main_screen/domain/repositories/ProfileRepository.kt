package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.features.main_screen.data.models.ProfileDTO

interface ProfileRepository {
    fun getProfile(): ProfileDTO
}