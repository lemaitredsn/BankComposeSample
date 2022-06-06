package ru.lemaitre.bankcomposesample.features.profile_screen.domain

import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.profile_screen.data.ProfileDTO
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.model.ProfileModel

object ProfileMapper {
    fun ProfileDTO.toDomain() = ProfileModel(
        name = this.name ?: "",
        surname = this.surname ?: "",
        photo = this.photo ?: R.drawable.ic_profile_circle,
        number = this.phone ?: ""
    )
}