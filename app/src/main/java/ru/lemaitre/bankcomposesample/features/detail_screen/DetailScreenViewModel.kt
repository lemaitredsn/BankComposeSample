package ru.lemaitre.bankcomposesample.features.detail_screen

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import ru.lemaitre.bankcomposesample.common.main.MainActivity


class DetailScreenViewModel @AssistedInject constructor(
    @Assisted private val productData: String
): ViewModel() {

    init {
        Log.e("TAG", "productData $productData")
    }

    @AssistedFactory
    interface Factory {
        fun create(productData: String): DetailScreenViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object{
        fun provideFactory(
            assistedFactory: Factory,
            productData: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(productData) as T
            }

        }
    }

}

@Composable
fun provideDetailScreenViewModel(productData: String): DetailScreenViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).detailScreenViewModelFactory()
    return viewModel(factory = DetailScreenViewModel.provideFactory(factory, productData))
}