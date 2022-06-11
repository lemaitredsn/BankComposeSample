package ru.lemaitre.bankcomposesample.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.profile.ProfileViewModel
import ru.lemaitre.bankcomposesample.features.main_screen.domain.models.ProfileModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    Column() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileDetail(viewModel.profile.value)
        }
    }
}

@Composable
fun ProfileDetail(profile: ProfileModel) {
    Row {
        Image(
            painter = painterResource(id = profile.photo),
            contentDescription = profile.name,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
        Column {
            Text(text = profile.name)
            Text(text = profile.surname)
            Text(text = profile.number)
        }
    }
}