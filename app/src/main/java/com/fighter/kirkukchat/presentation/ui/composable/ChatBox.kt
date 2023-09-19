package com.fighter.kirkukchat.presentation.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@Composable
fun ChatBox(
    chatBoxValue: String,
    onClickRecordVoice: () -> Unit,
    onClickSendButton: () -> Unit,
    onTyping: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
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
                .clickable { onClickRecordVoice() }
                .padding(8.dp),
            painter = painterResource(id = R.drawable.icon_mic),
            contentDescription = stringResource(R.string.mice_icon),
            tint = Theme.colors.primary
        )
        ChatTextField(
            modifier = Modifier.weight(1f),
            value = chatBoxValue,
            onValueChanged = onTyping::invoke
        )
        Icon(
            modifier = Modifier
                .clip(shape = CircleShape)
                .clickable { onClickSendButton() }
                .padding(8.dp),
            painter = painterResource(id = R.drawable.icon_send),
            contentDescription = stringResource(R.string.icon_send),
            tint = Theme.colors.primary
        )
    }
}