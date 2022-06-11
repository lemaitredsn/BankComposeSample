package ru.lemaitre.bankcomposesample.features.main_screen.mappers

import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.ProfileDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.ProfileModel

//fix model this is UI model
object ProfileMapper {
    fun ProfileDTO.toDomain() = ProfileModel(
        name = this.name ?: "",
        surname = this.surname ?: "",
        photo = this.photo ?: R.drawable.ic_profile_circle,
        number = this.phone ?: ""
    )
}