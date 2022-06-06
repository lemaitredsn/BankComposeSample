package ru.lemaitre.bankcomposesample.features.profile_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.ProfileUseCase
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.model.ProfileModel
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

