package com.fighter.kirkukchat.presentation.ui.chatScreen

interface ChatInteractionListener {
    fun onClickRecordAudio()
    fun onClickPause()
    fun onClickSend()
    fun onClickCancel()
    fun onTyping(value: String)
}