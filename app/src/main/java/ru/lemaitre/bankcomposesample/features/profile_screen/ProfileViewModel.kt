package ru.lemaitre.bankcomposesample.features.profile_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.ProfileUseCase
import ru.lemaitre.bankcomposesample.features.profile_screen.domain.model.ProfileModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
): ViewModel() {

    val _profile = mutableStateOf(ProfileModel())
    var profile: State<ProfileModel> = _profile

    init {
        getProfile()
    }

    fun getProfile(){

    }

}

