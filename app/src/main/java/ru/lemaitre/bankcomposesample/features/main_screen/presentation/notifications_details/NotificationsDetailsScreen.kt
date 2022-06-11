package ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationsDetailsScreen(viewModel: NotificationsDetailsViewModel) {
    val model = viewModel.notification.value
    Row {
        Icon(
            model.drawable,
            modifier = Modifier
                .padding(16.dp)
                .width(24.dp)
                .height(24.dp),
            contentDescription = model.title
        )

        Column {
            Text(text = model.title, fontSize = 24.sp)
            Text(text = model.descriptions, fontSize = 18.sp)
            Text(text = model.date)
        }
    }
}
