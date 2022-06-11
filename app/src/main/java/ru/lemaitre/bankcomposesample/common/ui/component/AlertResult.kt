package ru.lemaitre.bankcomposesample.common.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.lemaitre.bankcomposesample.common.ui.models.ResultUI

@Composable
fun AlertResult(
    result: ResultUI,
    onDismiss: (() -> Unit),
    onSuccessCallback: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = null,
        text = null,
        buttons = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = result.icon),
                    contentDescription = result.status,
                    modifier = Modifier
                        .padding(top = 35.dp)
                        .height(70.dp)
                        .fillMaxWidth()
                )
                Text(
                    result.status, fontSize = 24.sp,
                    fontWeight = FontWeight(800)
                )
                Text(result.message, fontSize = 14.sp)
            }
            Button(
                onClick = { onSuccessCallback() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp)
            ) {
                Text("OK", fontSize = 22.sp)
            }
        }
    )
}