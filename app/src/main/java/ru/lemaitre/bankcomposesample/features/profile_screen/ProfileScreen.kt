package ru.lemaitre.bankcomposesample.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.lemaitre.bankcomposesample.R

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
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
            Text(text = "Пустовалов")
            Text(text = "+ 7 (914) 378 66 39")
        }
    }
}