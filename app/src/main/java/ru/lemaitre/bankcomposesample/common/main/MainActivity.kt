package ru.lemaitre.bankcomposesample.common.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import ru.lemaitre.bankcomposesample.common.ui.theme.BankComposeSampleTheme
import ru.lemaitre.bankcomposesample.features.MainScreenConfiguration
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.new_product.NewProductViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications_details.NotificationsDetailsViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.offer_details.OfferDetailViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.product_details.DetailScreenViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankComposeSampleTheme {
                MainScreenConfiguration()
            }
        }
    }

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface ViewModelFactoryProvider {
        fun detailScreenViewModelFactory(): DetailScreenViewModel.Factory
        fun offerScreenViewModelFactory(): OfferDetailViewModel.Factory
        fun newProductScreenViewModelFactory(): NewProductViewModel.Factory
        fun notificationsDetailsViewModelFactory(): NotificationsDetailsViewModel.Factory
    }
}