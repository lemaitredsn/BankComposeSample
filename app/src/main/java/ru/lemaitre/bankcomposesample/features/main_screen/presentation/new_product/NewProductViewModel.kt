package ru.lemaitre.bankcomposesample.features.main_screen.presentation.new_product

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.toUpperCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import ru.lemaitre.bankcomposesample.common.domain.ProductState
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.common.mappers.MapperUI.toUI
import ru.lemaitre.bankcomposesample.common.ui.models.ResultUI
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NameProduct
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.NewProductModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.GetNewProductsUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.SendOrderedProductUseCase


class NewProductViewModel @AssistedInject constructor(
    @Assisted private val product: String,
    private val getNewProductsUseCase: GetNewProductsUseCase,
    private val sendOrderedProductUseCase: SendOrderedProductUseCase
) : ViewModel() {

    private val _productsVariants = mutableStateOf(emptyList<NewProductModel>())
    val productsVariants: State<List<NewProductModel>> = _productsVariants

    //переделать на State
    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    private val _result: MutableState<ResultUI?> = mutableStateOf(null)
    val result: State<ResultUI?> = _result

    init {
        getNewProducts()
    }

    private fun getNewProducts() {
        viewModelScope.launch {
            _productsVariants.value = getNewProductsUseCase(mapToDomain(product))
        }
    }

    private fun mapToDomain(name: String): NameProduct {
        return NameProduct.valueOf(name.uppercase())
    }

    fun orderClicked(name: String) {
        viewModelScope.launch {
            _loading.value = true
            _result.value = sendOrderedProductUseCase(name).toUI()
            _loading.value = false
        }
    }

    fun closeDialog() {
        _result.value = null
    }

    @AssistedFactory
    interface Factory {
        fun create(product: String): NewProductViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: NewProductViewModel.Factory,
            product: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(product) as T
            }

        }
    }
}

@Composable
fun provideNewProductViewModel(product: String): NewProductViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).newProductScreenViewModelFactory()
    return viewModel(factory = NewProductViewModel.provideFactory(factory, product))
}