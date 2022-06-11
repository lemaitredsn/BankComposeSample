package ru.lemaitre.bankcomposesample.features.main_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.data.Repositories.OfferRepositoryImpl
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.OfferRepository

@Module
@InstallIn(SingletonComponent::class)
class OfferDetailComponent {
    @Provides
    fun provideOfferRepository(storage: Storage): OfferRepository = OfferRepositoryImpl( storage)
}