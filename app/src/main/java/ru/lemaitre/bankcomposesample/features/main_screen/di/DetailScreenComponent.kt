package ru.lemaitre.bankcomposesample.features.main_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.data.repositories.DetailRepositoryImpl
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.DetailRepository

@Module
@InstallIn(SingletonComponent::class)
class DetailScreenComponent {
    @Provides
    fun providesDetailRepository(storage: Storage): DetailRepository = DetailRepositoryImpl(storage)
}