package com.fighter.kirkukchat.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@Composable
fun ReceiverItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    bottomStart = 2.dp,
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp
                )
            )
            .background(Theme.colors.surface)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = text,
            style = Theme.typography.body,
            color = Theme.colors.contentPrimary,
        )
    }

}

@Preview
@Composable
fun PreviewReceiverItem() {
    ReceiverItem(text = "Hello Ahmed , Where are you ?")
}