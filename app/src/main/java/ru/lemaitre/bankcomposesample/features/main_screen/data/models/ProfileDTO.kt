package ru.lemaitre.bankcomposesample.features.main_screen.data.models

import androidx.annotation.DrawableRes

data class ProfileDTO(
    val name: String? = null,
    val surname: String? = null,
    @DrawableRes val photo: Int? = null,
    val phone: String? = null,
)