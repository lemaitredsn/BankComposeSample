package ru.lemaitre.bankcomposesample.features.detail_screen

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.lemaitre.bankcomposesample.common.domain.StateData
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailModel
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailState
import ru.lemaitre.bankcomposesample.features.detail_screen.domain.DetailUseCase


class DetailScreenViewModel @AssistedInject constructor(
    @Assisted private val productData: String,
    private val useCase: DetailUseCase
) : ViewModel() {

    private val _detailProduct = mutableStateOf(DetailState())
    val detailProduct: State<DetailState> = _detailProduct

    init {
        Log.e("TAG", "prod $productData")
        getDetails(productData)
    }

    fun getDetails(productData: String) {
        viewModelScope.launch {
            useCase.getDetails(productData).collect { result ->
                when (result) {
                    is StateData.Success -> _detailProduct.value =
                        DetailState(details = result.data ?: DetailModel.getDefault())
                    is StateData.Error -> _detailProduct.value = DetailState(
                        error = result.message ?: "Произошла ошибка получения деталей продукта"
                    )
                    is StateData.Loading -> _detailProduct.value = DetailState(isLoading = true)
                }
            }
        }
    }


    @AssistedFactory
    interface Factory {
        fun create(productData: String): DetailScreenViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
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