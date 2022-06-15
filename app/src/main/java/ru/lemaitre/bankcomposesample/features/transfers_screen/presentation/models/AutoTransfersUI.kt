package ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.models

import androidx.annotation.DrawableRes


data class AutoTransfersUI(
    val name: String,
    @DrawableRes val icon: Int,
    val id: Long
)
