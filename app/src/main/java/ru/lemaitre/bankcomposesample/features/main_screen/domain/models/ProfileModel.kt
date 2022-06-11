package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R

data class ProfileModel(
    val name: String = "",
    val surname: String = "",
    @DrawableRes val photo: Int = R.drawable.ic_profile_circle,
    val number: String = ""
)