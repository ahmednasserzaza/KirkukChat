package com.fighter.kirkukchat.presentation.ui.chatScreen

import androidx.annotation.DrawableRes
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.domain.entity.ChatHistory

data class ChatUiState(
    val chatFieldValue: String = "",
    val username: String = "",
    val isOnline: Boolean = false,
    @DrawableRes val imageProfile: Int = R.drawable.profile_image,
    val chatHistory: List<ChatHistoryUiState> = emptyList(),
    val isRecording: Boolean = true,
    val inRecordMode: Boolean = false
)

data class ChatHistoryUiState(
    val identity: String = "",
    val message: String = "",
    val isSeen: Boolean = false,
    val isSender: Boolean = true
)

fun ChatHistory.toChatHistoryUiState(): ChatHistoryUiState {
    return ChatHistoryUiState(
        identity = identity,
        message = message,
        isSeen = isSeen,
        isSender = isSender
    )
}

fun List<ChatHistory>.toChatHistoryUiState() = map { it.toChatHistoryUiState() }