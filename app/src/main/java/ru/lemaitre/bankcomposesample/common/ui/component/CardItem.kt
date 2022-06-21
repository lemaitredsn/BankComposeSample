package ru.lemaitre.bankcomposesample.common.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.ui.theme.GrayAlpha54
import ru.lemaitre.bankcomposesample.common.ui.theme.blueA400
import ru.lemaitre.bankcomposesample.features.main_screen.presentation.main.models.CardUi

@Composable
fun CardItem(uiModel: CardUi, selected: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp, 2.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .clickable { selected(uiModel.number) },
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(blueA400)
        ) {
            Image(
                painter = painterResource(id = uiModel.iconPaySystem),
                contentDescription = uiModel.paySystem.title,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .width(50.dp)
                    .height(50.dp)
                    .background(GrayAlpha54)
                    .padding(8.dp)
            )
            Column(modifier = Modifier.weight(1f))
            {
                Text(uiModel.typeCard.title)
                Text(
                    stringResource(
                        id = R.string.main_screen_card_end,
                        uiModel.number.takeLast(4)
                    )
                )
            }
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                Text(text = "${uiModel.amount} ${uiModel.currency.character}")
            }
        }
    }
}