package ru.lemaitre.bankcomposesample.features.offer_detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.offer_detail.data.OfferRepositoryImpl
import ru.lemaitre.bankcomposesample.features.offer_detail.domain.OfferRepository

@Module
@InstallIn(SingletonComponent::class)
class OfferDetailComponent {
    @Provides
    fun provideOfferRepository(storage: Storage): OfferRepository = OfferRepositoryImpl( storage)
}