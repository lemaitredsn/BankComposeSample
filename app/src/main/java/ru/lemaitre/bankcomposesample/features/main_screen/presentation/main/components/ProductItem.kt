//package ru.lemaitre.bankcomposesample.features.main_screen.presentation
//
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.Card
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import ru.lemaitre.bankcomposesample.R
//import ru.lemaitre.bankcomposesample.common.domain.*
//import ru.lemaitre.bankcomposesample.common.ui.theme.GrayAlpha54
//import ru.lemaitre.bankcomposesample.common.ui.theme.blueA400
//import ru.lemaitre.bankcomposesample.common.ui.theme.yellow400
//
//@Composable
//fun Prod(
//    products: Products,
//    visible: Boolean,
//    selected: (Products) -> Unit
//) {
//    when (products) {
//        is CardsDomain -> ProductItem(cardDomain = products, visible, selected)
//        is AccountDomain -> ProductItem(accountProduct = products, visible, selected)
//        is OfferCardsModel -> OfferCardItem(offerCardModel = products, visible)
//        is EmptyCardsModel -> EmptyCardItem(emptyCardModel = products, visible)
//    }
//}
//
//@Composable
//fun ProductItem(
//    cardDomain: CardsDomain,
//    visible: Boolean,
//    selected: (Products) -> Unit
//) {
//    if (visible) {
//        Card(
//            modifier = Modifier
//                .padding(4.dp, 2.dp)
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .clickable { selected(cardDomain) },
//            elevation = 8.dp
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.background(blueA400)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_note),
//                    contentDescription = cardDomain.paySystem.title,
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .clip(CircleShape)
//                        .width(50.dp)
//                        .height(50.dp)
//                        .background(GrayAlpha54)
//                        .padding(8.dp)
//                )
//                Column(modifier = Modifier.weight(1f))
//                {
//                    Text(cardDomain.typeCard.title)
//                    Text(
//                        stringResource(
//                            id = R.string.main_screen_card_end,
//                            cardDomain.number.takeLast(4)
//                        )
//                    )
//                }
//                Column(
//                    modifier = Modifier
//                        .padding(end = 16.dp)
//                ) {
//                    Text(text = "${cardDomain.amount} ${cardDomain.currency.character}")
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun ProductItem(
//    accountProduct: AccountDomain,
//    visible: Boolean,
//    selected: (Products) -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .padding(4.dp, 2.dp)
//            .fillMaxSize()
//            .clickable {
//                selected(accountProduct)
//            },
//        elevation = 8.dp
//    ) {
//        if (visible) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.background(blueA400)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_card),
//                    contentDescription = accountProduct.typeAccount.title,
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .clip(CircleShape)
//                        .width(50.dp)
//                        .height(50.dp)
//                        .background(GrayAlpha54)
//                        .padding(8.dp)
//                )
//                Column(modifier = Modifier.weight(1f))
//                {
//                    Text(accountProduct.typeAccount.title)
//                    Text(accountProduct.number)
//                }
//                Column(
//                    modifier = Modifier
//                        .padding(end = 16.dp)
//                ) {
//                    Text(text = "${accountProduct.amount} ${accountProduct.currency.character}")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun EmptyCardItem(
//    emptyCardModel: EmptyCardsModel,
//    visible: Boolean
//) {
//    Card(
//        modifier = Modifier
//            .padding(4.dp, 2.dp)
//            .fillMaxSize(),
//        elevation = 8.dp
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.background(GrayAlpha54)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_card),
//                contentDescription = emptyCardModel.message,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clip(CircleShape)
//                    .width(50.dp)
//                    .height(50.dp)
//                    .background(GrayAlpha54)
//                    .padding(8.dp)
//            )
//            Column(modifier = Modifier.weight(1f))
//            {
//                Text(emptyCardModel.message)
//            }
//        }
//    }
//}
//
//@Composable
//fun OfferCardItem(
//    offerCardModel: OfferCardsModel,
//    visible: Boolean
//) {
//    Card(
//        modifier = Modifier
//            .padding(4.dp, 2.dp)
//            .fillMaxSize(),
//        elevation = 8.dp
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.background(yellow400)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_card),
//                contentDescription = offerCardModel.message,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clip(CircleShape)
//                    .width(50.dp)
//                    .height(50.dp)
//                    .background(GrayAlpha54)
//                    .padding(8.dp)
//            )
//            Column(modifier = Modifier.weight(1f))
//            {
//                Text(offerCardModel.message)
//            }
//        }
//    }
//}
//
//
