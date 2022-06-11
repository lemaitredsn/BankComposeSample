package ru.lemaitre.bankcomposesample.features.main_screen.mappers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NotificationDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NotificationModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications.models.NotificationDetailsUI

object NotificationMapper {
    fun NotificationDTO.toDomain() = NotificationModel(
        title = this.title,
        descriptions = this.descriptions,
        id = this.id,
        date = this.date
    )

    fun NotificationModel.toUi() = NotificationDetailsUI(
        title = this.title,
        descriptions = this.descriptions,
        date = this.date,
        drawable = Icons.Filled.Notifications
    )
}