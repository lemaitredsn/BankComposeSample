
package ru.lemaitre.bankcomposesample.features.main_screen.data.repositories

import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NotificationDTO
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NotificationRepository
import javax.inject.Inject

class NotificationRepositoryImp @Inject constructor(
    private val storage: Storage
): NotificationRepository {
    override fun getNotifications(): List<NotificationDTO> {
        return storage.getNotifications()
    }

}
