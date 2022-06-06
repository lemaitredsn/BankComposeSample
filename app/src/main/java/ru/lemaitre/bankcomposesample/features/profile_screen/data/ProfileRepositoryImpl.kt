package ru.lemaitre.bankcomposesample.features.profile_screen.data

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val storage: Storage
): ProfileRepository {

    override fun getProfile() = storage.getProfile()

}
