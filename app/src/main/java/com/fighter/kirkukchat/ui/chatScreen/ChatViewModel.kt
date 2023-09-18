package com.fighter.kirkukchat.ui.chatScreen

import androidx.lifecycle.ViewModel
import com.fighter.kirkukchat.data.FakeDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val dataSource: FakeDataSource) : ViewModel(),
    ChatInteractionListener {

    private val _chatState = MutableStateFlow(ChatUiState())
    val chatState = _chatState.asStateFlow()

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        val userInfo = dataSource.getUserInfo()
        _chatState.update {
            it.copy(
                username = userInfo.username,
                imageProfile = userInfo.image,
                isOnline = userInfo.isOnline
            )
        }
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