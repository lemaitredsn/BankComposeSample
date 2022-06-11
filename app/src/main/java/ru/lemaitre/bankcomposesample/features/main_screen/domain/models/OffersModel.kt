package ru.lemaitre.bankcomposesample.features.main_screen.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.ui.theme.blueA400

data class OffersModel(
    val id: Long = 0,
    val title: String = "Депозит 23%",
    val description: String = "Акция действует до 23 февраля",
    @DrawableRes val icon: Int? = R.drawable.ic_card,
    @DrawableRes val backImage: Int = R.drawable.ic_launcher_foreground,
    val backgroundColor: Color = blueA400
)
