package com.fighter.kirkukchat.domain.entity

import androidx.annotation.IntegerRes

data class UserInfo(
    val username: String,
    @IntegerRes val image: Int,
    val isOnline: Boolean
)
