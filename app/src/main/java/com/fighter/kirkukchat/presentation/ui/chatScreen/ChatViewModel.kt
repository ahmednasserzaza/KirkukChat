package com.fighter.kirkukchat.presentation.ui.chatScreen

import androidx.lifecycle.ViewModel
import com.fighter.kirkukchat.data.FakeDataSource
import com.fighter.kirkukchat.domain.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val chatRepository: ChatRepository) : ViewModel(),
    ChatInteractionListener {

    private val _chatState = MutableStateFlow(ChatUiState())
    val chatState = _chatState.asStateFlow()

    init {
        getUserInfo()
        getChatHistory()
    }

    private fun getUserInfo() {
        val userInfo = chatRepository.getUserInfo()
        _chatState.update {
            it.copy(
                username = userInfo.username,
                imageProfile = userInfo.image,
                isOnline = userInfo.isOnline
            )
        }
    }

    private fun getChatHistory() {
        val chatHistory = chatRepository.getChatHistory().toChatHistoryUiState()
        _chatState.update { it.copy(chatHistory = chatHistory) }
    }

    override fun onClickRecord() {
        TODO("Not yet implemented")
    }

    override fun onClickPause() {
        TODO("Not yet implemented")
    }

    override fun onClickStop() {
        TODO("Not yet implemented")
    }

    override fun onClickSend() {
        TODO("Not yet implemented")
    }

    override fun onTyping(value: String) {
        _chatState.update { it.copy(chatFieldValue = value) }
    }
}