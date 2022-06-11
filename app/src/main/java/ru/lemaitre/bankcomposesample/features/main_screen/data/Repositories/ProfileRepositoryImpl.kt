package ru.lemaitre.bankcomposesample.features.main_screen.data.Repositories

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val storage: Storage
): ProfileRepository {

    override fun getProfile() = storage.getProfile()

}
