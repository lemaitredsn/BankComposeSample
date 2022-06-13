package ru.lemaitre.bankcomposesample.features.main_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.lemaitre.bankcomposesample.common.data.Storage
import ru.lemaitre.bankcomposesample.features.main_screen.data.repositories.NewProductsRepositoryImpl
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.NewProductsRepository

@Module
@InstallIn(SingletonComponent::class)
class NewProductsComponent {
    @Provides
    fun provideNewProductsRepository(storage: Storage): NewProductsRepository {
        return NewProductsRepositoryImpl(storage = storage)
    }
}