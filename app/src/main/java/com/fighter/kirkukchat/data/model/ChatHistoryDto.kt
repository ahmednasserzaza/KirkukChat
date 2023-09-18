package com.fighter.kirkukchat.data.model

import com.fighter.kirkukchat.domain.entity.ChatHistory

data class ChatHistoryDto(
    val identity: String,
    val message: String? = null,
    val isSeen: Boolean? = null,
    val isSender: Boolean? = null
)

fun ChatHistoryDto.toEntity(): ChatHistory {
    return ChatHistory(
        identity = identity,
        message = message ?: "",
        isSeen = isSeen ?: false,
        isSender = identity == "Ahmed Nasser"
    )
}

fun List<ChatHistoryDto>.toEntity(): List<ChatHistory> = map { it.toEntity() }