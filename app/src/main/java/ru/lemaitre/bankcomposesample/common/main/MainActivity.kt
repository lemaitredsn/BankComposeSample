package ru.lemaitre.bankcomposesample.common.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import ru.lemaitre.bankcomposesample.features.*
import ru.lemaitre.bankcomposesample.features.detail_screen.DetailScreenViewModel
import ru.lemaitre.bankcomposesample.ui.theme.BankComposeSampleTheme

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
    }
}