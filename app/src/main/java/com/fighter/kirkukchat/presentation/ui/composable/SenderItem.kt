package com.fighter.kirkukchat.presentation.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@Composable
fun SenderItem(
    text: String,
    isSeen: Boolean,
    modifier: Modifier = Modifier,
) {
    val seenIconColor = animateColorAsState(
        targetValue = if (isSeen) Theme.colors.primary else Theme.colors.contentTertiary,
        label = ""
    )
    Column(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    bottomStart = 8.dp,
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 2.dp
                )
            )
            .background(Theme.colors.pink)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.End

    ) {
        Text(
            text = text,
            style = Theme.typography.body,
            color = Theme.colors.contentPrimary,
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_seen),
            contentDescription = stringResource(R.string.icon_seen),
            tint = seenIconColor.value
        )
    }
}

@Preview
@Composable
fun PreviewSenderItem() {
    SenderItem(text = "Hello , nice to meet you !", isSeen = false)
}