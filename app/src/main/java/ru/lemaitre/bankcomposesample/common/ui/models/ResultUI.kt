package ru.lemaitre.bankcomposesample.common.ui.models

import androidx.annotation.DrawableRes

data class ResultUI(
    val status: String,
    val message: String,
    @DrawableRes val icon: Int
)