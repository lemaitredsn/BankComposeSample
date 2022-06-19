package ru.lemaitre.bankcomposesample.common.main.domain.model

sealed class Screens(
    val name: String
) {
    object Profile : Screens("Profile")
    object Notifications : Screens("Notifications")
    object CardDetails : Screens("Card")
    object OfferDetail: Screens("OfferDetail")
    object NewProduct: Screens("NewProduct")
    object NotificationDetails: Screens("NotificationDetails")
}