package ru.lemaitre.bankcomposesample.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.features.profile_screen.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    Column() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileDetail()
        }
    }
}

@Composable
@Preview
fun ProfileDetail() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_profile_circle),
            contentDescription = "avatar",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
        Column {
            Text(text = "Вячеслав")
            Text(text = "Иванов")
            Text(text = "+ 7 (914) 333 22 11")
        }
    }
}