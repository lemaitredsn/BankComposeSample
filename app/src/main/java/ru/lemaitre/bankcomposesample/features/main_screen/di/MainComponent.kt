package ru.lemaitre.bankcomposesample.features.main_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.lemaitre.bankcomposesample.features.main_screen.data.Repositories.MainScreenRepositoryImpl
import ru.lemaitre.bankcomposesample.features.main_screen.domain.repositories.MainScreenRepository

@Module
@InstallIn(ViewModelComponent::class)
class MainScreenComponent {
    @Provides
    fun getMainScreenRepository(repositoryImpl: MainScreenRepositoryImpl): MainScreenRepository {
        return repositoryImpl
    }
}