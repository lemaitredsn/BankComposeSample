package ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories

import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NotificationDTO

interface NotificationRepository {
    fun getNotifications (): List<NotificationDTO>
}
