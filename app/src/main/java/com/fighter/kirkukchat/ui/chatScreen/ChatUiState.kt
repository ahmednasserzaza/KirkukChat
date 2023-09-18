package com.fighter.kirkukchat.ui.chatScreen

import androidx.annotation.DrawableRes
import com.fighter.kirkukchat.R

data class ChatUiState(
    val chatFieldValue: String = "",
    val username: String = "",
    val isOnline: Boolean = false,
    @DrawableRes val imageProfile: Int = R.drawable.profile_image
)