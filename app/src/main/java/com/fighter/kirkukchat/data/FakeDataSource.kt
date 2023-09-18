package com.fighter.kirkukchat.data

import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.data.model.ChatHistoryDto
import com.fighter.kirkukchat.data.model.UserInfoDto
import com.fighter.kirkukchat.di.ResourceProvider
import javax.inject.Inject

class FakeDataSource @Inject constructor(private val resourceProvider: ResourceProvider) {
    fun getUserInfo(): UserInfoDto {
        return UserInfoDto(
            username = resourceProvider.getString(R.string.username),
            image = resourceProvider.getDrawable(R.drawable.profile_image),
            isOnline = true
        )
    }

    fun getChatHistory(): List<ChatHistoryDto> {
        return listOf(
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "Hello there !",
                isSeen = true,
            ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "Hi, I am Mohamed",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "Where are you from ?",
                isSeen = true,
                ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "I am from Iraq , And you ?",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "I am from Egypt , Pleased to meet you",
                isSeen = true,
                ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "Nice to meet you too",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "I wanna ask a question !!",
                isSeen = true
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "Hello , Are you available now !? ",
                isSeen = true
            ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "Yes, I'm here. What's your question?",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "I was wondering if you could recommend a good book to read?",
                isSeen = true
            ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "Of course! What genre are you interested in?",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "I enjoy science fiction. Do you have any favorites?",
                isSeen = true
            ),
            ChatHistoryDto(
                identity = "Mohamed Hassan",
                message = "I'm a big fan of Isaac Asimov. His Foundation series is fantastic!",
            ),
            ChatHistoryDto(
                identity = "Ahmed Nasser",
                message = "Thanks for the recommendation! I'll check it out.",
                isSeen = false
            ),
        )
    }
}