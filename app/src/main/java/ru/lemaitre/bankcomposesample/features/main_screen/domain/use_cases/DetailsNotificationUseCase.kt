package ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NotificationModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NotificationRepository
import ru.lemaitre.bankcomposesample.features.main_screen.mappers.NotificationMapper.toDomain
import javax.inject.Inject

class DetailsNotificationUseCase @Inject constructor(
    private val notificationRepository: NotificationRepository
) {
    operator fun invoke(idNotification: String): NotificationModel {
        return requireNotNull(
            notificationRepository.getNotifications().find {
                it.id == idNotification.toLong()
            }?.toDomain())//fixme add mapper
    }
}

