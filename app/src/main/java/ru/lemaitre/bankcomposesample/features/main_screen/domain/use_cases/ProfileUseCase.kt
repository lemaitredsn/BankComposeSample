package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.features.main_screen.data.repositories.ProfileRepositoryImpl
import ru.lemaitre.bankcomposesample.features.main_screen.mappers.ProfileMapper.toDomain
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profile: ProfileRepositoryImpl
) {
    operator fun invoke() = profile.getProfile().toDomain()
}
