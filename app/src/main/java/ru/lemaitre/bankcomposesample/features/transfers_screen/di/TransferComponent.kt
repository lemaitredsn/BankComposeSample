package ru.lemaitre.bankcomposesample.features.transfers_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.transfers_screen.data.repositories.TransferRepositoryImpl
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.repositories.TransferRepository

@Module
@InstallIn(SingletonComponent::class)
class TransferComponent {
    @Provides
    fun provideTransfersRepository(storage: Storage): TransferRepository{
        return TransferRepositoryImpl(storage)
    }
}