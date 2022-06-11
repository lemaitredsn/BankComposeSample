package ru.lemaitre.bankcomposesample.features.notification_screen.domain

import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NotificationRepository
import ru.lemaitre.bankcomposesample.features.main_screen.mappers.NotificationMapper.toDomain
import javax.inject.Inject


class NotificationUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    operator fun invoke() = repository.getNotifications().map {
        it.toDomain()
    }
}

