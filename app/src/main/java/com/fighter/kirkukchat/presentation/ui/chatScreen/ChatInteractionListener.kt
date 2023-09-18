package com.fighter.kirkukchat.presentation.ui.chatScreen

interface ChatInteractionListener {
    fun onClickRecord()
    fun onClickPause()
    fun onClickStop()
    fun onClickSend()
    fun onTyping(value: String)
}