package ru.lemaitre.bankcomposesample.features.profile_screen.domain

import ru.lemaitre.bankcomposesample.features.profile_screen.data.ProfileDTO

interface ProfileRepository {
    fun getProfile(): ProfileDTO
}