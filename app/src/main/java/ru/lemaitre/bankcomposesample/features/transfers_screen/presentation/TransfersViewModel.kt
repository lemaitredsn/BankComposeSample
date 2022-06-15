package ru.lemaitre.bankcomposesample.features.transfers_screen.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.lemaitre.bankcomposesample.features.transfers_screen.domain.use_case.AutoTransfersUseCase
import ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.mappers.MapperTransfersUI.toUI
import ru.lemaitre.bankcomposesample.features.transfers_screen.presentation.models.AutoTransfersUI
import javax.inject.Inject

@HiltViewModel
class TransfersViewModel @Inject constructor(
    private val autoTransfersUseCase: AutoTransfersUseCase
) : ViewModel() {

    private val _autoTransfers = mutableStateOf(emptyList<AutoTransfersUI>())
    val autoTransfers: State<List<AutoTransfersUI>> = _autoTransfers

    init {
        getAutoTransfers()
    }

    private fun getAutoTransfers() {
        viewModelScope.launch {
            _autoTransfers.value = autoTransfersUseCase()
                .map {
                    it.toUI()
                }
        }
    }

}