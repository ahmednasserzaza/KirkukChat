package com.fighter.kirkukchat.domain.entity

data class ChatHistory(
    val identity: String,
    val message: String,
    val isSeen: Boolean,
    val isSender: Boolean
)