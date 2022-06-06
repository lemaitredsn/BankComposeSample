package ru.lemaitre.bankcomposesample.features.profile_screen.data

import androidx.annotation.DrawableRes

data class ProfileDTO(
    val name: String? = null,
    val surname: String? = null,
    @DrawableRes val photo: Int? = null,
    val phone: String? = null,
)