package com.fighter.kirkukchat.ui.chatScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
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
import com.fighter.kirkukchat.ui.composable.ChatAppBar
import com.fighter.kirkukchat.ui.composable.ChatTextField
import com.fighter.kirkukchat.ui.theme.Theme

@JvmOverloads
@Composable
fun ChatScreen(viewModel: ChatViewModel = hiltViewModel()) {
    val state by viewModel.chatState.collectAsState()
    ChatScreenContent(state = state, listener = viewModel)

}

@SuppressLint("ResourceType")
@Composable
fun ChatScreenContent(
    state: ChatUiState,
    listener: ChatInteractionListener
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.primary),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
                .background(Theme.colors.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Icon(
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
                    painter = painterResource(id = R.drawable.icon_send),
                    contentDescription = stringResource(R.string.icon_send),
                    tint = Theme.colors.primary
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