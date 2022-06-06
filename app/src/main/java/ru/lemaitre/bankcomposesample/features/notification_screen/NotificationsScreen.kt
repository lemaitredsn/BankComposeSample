package ru.lemaitre.bankcomposesample.features.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NotificationsScreen(viweModel: NotificationViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val notification = viweModel.notifications.value
        notification.forEach {
            NotificationItem(it)
        }
    }
}


data class NotificationModel(val title: String, val id: Long, val descriptions: String)

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