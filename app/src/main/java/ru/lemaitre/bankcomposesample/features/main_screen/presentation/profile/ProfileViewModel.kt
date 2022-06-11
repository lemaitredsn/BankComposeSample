package ru.lemaitre.bankcomposesample.features.main_screen.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.use_cases.ProfileUseCase
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.ProfileModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
): ViewModel() {

    private val _profile = mutableStateOf(ProfileModel())
    var profile: State<ProfileModel> = _profile

    init {
        getProfile()
    }

    fun getProfile(){
        _profile.value = profileUseCase()
    }

}

