package ru.lemaitre.bankcomposesample.features.notification_screen.domain

import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NotificationModel
import ru.lemaitre.bankcomposesample.features.main_screen.data.Repositories.NotificationRepositoryImp
import ru.lemaitre.bankcomposesample.features.main_screen.data.models.NotificationDTO
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
