package com.fighter.kirkukchat.data

import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.data.model.UserInfo
import com.fighter.kirkukchat.di.ResourceProvider
import javax.inject.Inject

class FakeDataSource @Inject constructor(private val resourceProvider: ResourceProvider) {
    fun getUserInfo(): UserInfo {
        return UserInfo(
            username =resourceProvider.getString(R.string.username),
            image = resourceProvider.getDrawable(R.drawable.profile_image),
            isOnline = true
        )
    }

    fun getChatHistory() {

    }
}