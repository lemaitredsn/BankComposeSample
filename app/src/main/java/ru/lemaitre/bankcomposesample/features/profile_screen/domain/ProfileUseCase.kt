package ru.lemaitre.bankcomposesample.features.profile_screen.domain

import ru.lemaitre.bankcomposesample.features.profile_screen.data.ProfileRepositoryImpl
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.ProfileMapper.toDomain
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profile: ProfileRepositoryImpl
) {
    operator fun invoke() = profile.getProfile().toDomain()
}
