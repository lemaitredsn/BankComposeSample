package ru.lemaitre.bankcomposesample.features.profile_screen.domain.model

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R

data class ProfileModel(
    val name: String = "",
    val surname: String = "",
    @DrawableRes val photo: Int = R.drawable.ic_profile_circle,
    val number: String = ""
)