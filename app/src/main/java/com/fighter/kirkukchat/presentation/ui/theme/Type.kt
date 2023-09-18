package com.fighter.kirkukchat.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fighter.kirkukchat.R

@Composable
fun textBody(): TextStyle {
    return TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.W400,
    )
}

@Composable
fun textSubTitle(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.W500,
    )
}

@Composable
fun textTitle(): TextStyle {
    return TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontWeight = FontWeight.W600,
    )
}