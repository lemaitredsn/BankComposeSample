package ru.lemaitre.bankcomposesample.features.main_screen.presentation

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.lemaitre.bankcomposesample.features.main_screen.domain.OffersModel
import ru.lemaitre.bankcomposesample.common.ui.theme.GrayAlpha54

@Composable
fun OffersItemView(
    offersModel: OffersModel,
    selected: (String) -> Unit
) {
    val localContext = LocalContext.current
    val dm = localContext.resources.displayMetrics
    val cardWidth = dm.widthPixels / dm.density - 26

    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(cardWidth.dp)
            .clickable { selected(offersModel.title) },
        elevation = 8.dp
    ) {
        ConstraintLayout(modifier = Modifier.background((offersModel.backgroundColor))) {
            val (logo, offersInfo) = createRefs()
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp)
                    .constrainAs(logo) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = offersModel.backImage),
                contentDescription = offersModel.title,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .constrainAs(ref = offersInfo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (offersModel.icon != null) {
                    Image(
                        painter = painterResource(offersModel.icon),
                        contentDescription = offersModel.title,
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(CircleShape)
                            .background(GrayAlpha54)
                            .padding(8.dp)
                    )
                }
                Column() {
                    Text(
                        text = offersModel.title,
                        fontSize = 24.sp
                    )
                    Text(
                        text = offersModel.description,
                        style = TextStyle(textAlign = TextAlign.Justify)
                    )
                }
            }
        }
    }
}