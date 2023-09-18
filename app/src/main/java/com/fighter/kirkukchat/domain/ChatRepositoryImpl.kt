package com.fighter.kirkukchat.domain

import com.fighter.kirkukchat.data.FakeDataSource
import com.fighter.kirkukchat.data.model.toEntity
import com.fighter.kirkukchat.domain.entity.ChatHistory
import com.fighter.kirkukchat.domain.entity.UserInfo
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val fakeDataSource: FakeDataSource,
) : ChatRepository {
    override fun getUserInfo(): UserInfo {
        return fakeDataSource.getUserInfo().toEntity()
    }

    override fun getChatHistory(): List<ChatHistory> {
        return fakeDataSource.getChatHistory().toEntity()
    }
}