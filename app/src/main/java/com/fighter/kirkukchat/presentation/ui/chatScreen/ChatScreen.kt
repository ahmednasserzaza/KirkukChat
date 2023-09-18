package com.fighter.kirkukchat.presentation.ui.chatScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.presentation.ui.composable.ChatAppBar
import com.fighter.kirkukchat.presentation.ui.composable.ChatTextField
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreenContent(
    state: ChatUiState,
    listener: ChatInteractionListener
) {
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
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                stickyHeader {

                }
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Icon(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { listener.onClickRecordAudio() }
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.icon_mic),
                        contentDescription = stringResource(R.string.mice_icon),
                        tint = Theme.colors.primary
                    )
                    ChatTextField(
                        modifier = Modifier.weight(1f),
                        value = state.chatFieldValue,
                        onValueChanged = listener::onTyping
                    )
                    Icon(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { listener.onClickSend() }
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.icon_send),
                        contentDescription = stringResource(R.string.icon_send),
                        tint = Theme.colors.primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}