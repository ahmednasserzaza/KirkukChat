package com.fighter.kirkukchat.domain

import com.fighter.kirkukchat.domain.entity.ChatHistory
import com.fighter.kirkukchat.domain.entity.UserInfo

interface ChatRepository {
    fun getUserInfo(): UserInfo
    fun getChatHistory(): List<ChatHistory>
}