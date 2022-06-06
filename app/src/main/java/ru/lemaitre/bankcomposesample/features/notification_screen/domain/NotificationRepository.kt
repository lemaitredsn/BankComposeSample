package ru.lemaitre.bankcomposesample.features.notification_screen.domain

import ru.lemaitre.bankcomposesample.features.notification_screen.data.model.NotificationDTO

interface NotificationRepository {
    fun getNotifications (): List<NotificationDTO>
}
