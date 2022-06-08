package ru.lemaitre.bankcomposesample.features.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.lemaitre.bankcomposesample.features.notification_screen.domain.model.NotificationModel

@Composable
fun NotificationsScreen(viewModel: NotificationViewModel = hiltViewModel()) {
    //todo добавить открытие экрана для просмотра деталей
    Column(modifier = Modifier.fillMaxWidth()) {
        val notification = viewModel.notifications.value
        notification.forEach {
            NotificationItem(it)
        }
    }
}


@Composable
fun NotificationItem(notification: NotificationModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Notifications,
            modifier = Modifier
                .padding(16.dp)
                .width(24.dp)
                .height(24.dp),
            contentDescription = notification.title
        )
        Text(text = notification.title)
    }
}