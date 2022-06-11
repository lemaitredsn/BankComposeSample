package ru.lemaitre.bankcomposesample.features.add_product.presentation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import ru.lemaitre.bankcomposesample.common.main.MainActivity
import ru.lemaitre.bankcomposesample.features.add_product.domain.model.NewProductModel


class NewProductViewModel @AssistedInject constructor(
    @Assisted private val product: String
): ViewModel() {

    private val _productsVariants = mutableStateOf(
        listOf(
            NewProductModel(
                "Стандарт", "Стандартная карта",
                "Рубли", "4 года", "Стандартные условия"
            ),
            NewProductModel(
                "Доллар", "Если нужны доллары",
                "доллар", "евро", "4 года"
            ),
            NewProductModel(
                "Евро", "Евро для поездок в Европу",
                "евро", "4 года", "Лучшие"
            )
        )
    )
    val productsVariants: State<List<NewProductModel>> = _productsVariants

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