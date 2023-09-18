package com.fighter.kirkukchat.data.model

import androidx.annotation.IntegerRes
import com.fighter.kirkukchat.domain.entity.UserInfo

data class UserInfoDto(
    val username: String,
    @IntegerRes val image: Int,
    val isOnline: Boolean
)

fun UserInfoDto.toEntity(): UserInfo {
    return UserInfo(
        username = username,
        image = image,
        isOnline = isOnline
    )
}