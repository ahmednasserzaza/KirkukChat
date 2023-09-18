package com.fighter.kirkukchat.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primary: Color,
    val contentPrimary: Color,
    val contentTertiary: Color,
    val surface: Color,
    val onPrimary:Color,
    val background: Color,
    val pink: Color,
)

val LightColors = Colors(
    primary = Color(0xFFF53D47),
    contentPrimary = Color(0xDE1F0000),
    contentTertiary = Color(0x611F0000),
    surface = Color(0xFFFFFFFF),
    background = Color(0xFFFAFAFA),
    pink = Color(0xFFFFD0CC),
    onPrimary = Color(0xFFFFFFFF)
)

val DarkColors = Colors(
    primary = Color(0xFFC53D44),
    contentPrimary = Color(0xDEFFFFFF),
    contentTertiary = Color(0x61FFFFFF),
    surface = Color(0xFF1C1C1C),
    background = Color(0xFF151515),
    pink = Color(0xFF261F1F),
    onPrimary = Color(0xFFFFECEC)
)