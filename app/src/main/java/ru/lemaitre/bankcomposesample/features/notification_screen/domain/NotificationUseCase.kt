package ru.lemaitre.bankcomposesample.features.notification_screen.domain

import ru.lemaitre.bankcomposesample.features.notification_screen.NotificationModel
import ru.lemaitre.bankcomposesample.features.notification_screen.data.NotificationRepositoryImp
import ru.lemaitre.bankcomposesample.features.notification_screen.data.model.NotificationDTO
import ru.lemaitre.bankcomposesample.features.notification_screen.domain.NotificationMapper.toDomain
import javax.inject.Inject


class NotificationUseCase @Inject constructor(
    private val repository: NotificationRepositoryImp
) {
    operator fun invoke() = repository.getNotifications().map {
        it.toDomain()
    }
}

object NotificationMapper {
    fun NotificationDTO.toDomain() = NotificationModel(
        title = this.title,
        descriptions = this.descriptions,
        id = this.id
    )
}
