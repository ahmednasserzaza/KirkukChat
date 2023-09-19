package com.fighter.kirkukchat.presentation.ui.chatScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.kirkukchat.presentation.ui.composable.ChatAppBar
import com.fighter.kirkukchat.presentation.ui.composable.ChatBox
import com.fighter.kirkukchat.presentation.ui.composable.ReceiverItem
import com.fighter.kirkukchat.presentation.ui.composable.RecordView
import com.fighter.kirkukchat.presentation.ui.composable.SenderItem
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@JvmOverloads
@Composable
fun ChatScreen(viewModel: ChatViewModel = hiltViewModel()) {
    val state by viewModel.chatState.collectAsState()
    ChatScreenContent(state = state, listener = viewModel)
}

@Composable
fun ChatScreenContent(
    state: ChatUiState,
    listener: ChatInteractionListener
) {
    val lazyListState = rememberLazyListState()

    LaunchedEffect(lazyListState) {
        val lastIndex = state.chatHistory.size - 1
        if (lastIndex >= 0) {
            lazyListState.scrollToItem(lastIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.primary),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChatAppBar(
            image = painterResource(id = state.imageProfile),
            name = state.username,
            isOnline = state.isOnline
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
                .background(Theme.colors.background),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                state = lazyListState
            ) {

                items(state.chatHistory) { chatItem ->
                    if (chatItem.isSender) {
                        SenderItem(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .wrapContentWidth(Alignment.End)
                                .padding(start = 36.dp),
                            text = chatItem.message,
                            isSeen = chatItem.isSeen
                        )
                    } else {
                        ReceiverItem(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentWidth(Alignment.Start)
                                .padding(end = 36.dp),
                            text = chatItem.message
                        )
                    }
                }
            }

            AnimatedVisibility(visible = state.inRecordMode) {
                RecordView(
                    modifier = Modifier,
                    isRecording = state.isRecording,
                    onClickCancel = listener::onClickCancel,
                    onClickPause = listener::onClickPause,
                    onClickSend = listener::onClickSend
                )
            }

            AnimatedVisibility(visible = !state.inRecordMode) {
                ChatBox(
                    chatBoxValue = state.chatFieldValue,
                    onClickRecordVoice = listener::onClickRecordAudio,
                    onClickSendButton = listener::onClickSend,
                    onTyping = listener::onTyping
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}