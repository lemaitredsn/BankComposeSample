package ru.lemaitre.bankcomposesample.features.profile_screen.domain

import ru.lemaitre.bankcomposesample.features.profile_screen.domain.model.ProfileModel

interface ProfileRepository {
    fun getProfile(): ProfileModel
}