package ru.lemaitre.bankcomposesample.features.notification_screen.data

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.notification_screen.data.model.NotificationDTO
import ru.lemaitre.bankcomposesample.features.notification_screen.domain.NotificationRepository
import javax.inject.Inject

class NotificationRepositoryImp @Inject constructor(
    private val storage: Storage
): NotificationRepository {
    override fun getNotifications(): List<NotificationDTO> {
        return storage.getNotifications()
    }

}
