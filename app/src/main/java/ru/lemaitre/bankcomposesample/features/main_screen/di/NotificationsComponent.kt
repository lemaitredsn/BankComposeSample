package ru.lemaitre.bankcomposesample.features.main_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.data.repositories.NotificationRepositoryImp
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NotificationRepository

@Module
@InstallIn(SingletonComponent::class)
class NotificationsComponent {
    @Provides
    fun provideNotificationRepository(storage: Storage): NotificationRepository =
        NotificationRepositoryImp(storage)
}