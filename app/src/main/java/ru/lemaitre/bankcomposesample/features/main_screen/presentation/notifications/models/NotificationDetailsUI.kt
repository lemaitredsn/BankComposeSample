package ru.lemaitre.bankcomposesample.features.main_screen.presentation.notifications.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NotificationDetailsUI(
    val title: String,
    val descriptions: String,
    val date: String,
    val drawable: ImageVector
)
