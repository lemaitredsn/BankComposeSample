package ru.lemaitre.bankcomposesample.common.main.domain.model

import ru.lemaitre.bankcomposesample.common.domain.Products

sealed class Screens(
    val name: String
) {
    object Profile : Screens("Profile")
    object Notifications : Screens("Notifications")
    object CardDetails : Screens("Card")
    object OfferDetail: Screens("OfferDetail")
}