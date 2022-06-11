package ru.lemaitre.bankcomposesample.features.detail_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailRepositoryImpl
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailRepository

@Module
@InstallIn(SingletonComponent::class)
class DetailScreenComponent {
    @Provides
    fun providesDetailRepository(storage: Storage):DetailRepository = DetailRepositoryImpl(storage)
}