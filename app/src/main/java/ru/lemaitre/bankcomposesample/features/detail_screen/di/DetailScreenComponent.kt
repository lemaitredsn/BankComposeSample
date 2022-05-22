package ru.lemaitre.bankcomposesample.features.detail_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.lemaitre.bankcomposesample.features.detail_screen.data.DetailRepositoryImpl
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailRepository

@Module
@InstallIn(ViewModelComponent::class)
class DetailScreenComponent {
    @Provides
    fun getDetailRepository(repositoryImpl: DetailRepositoryImpl): DetailRepository = repositoryImpl
}