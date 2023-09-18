package com.fighter.kirkukchat.presentation.ui.composable

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@Composable
fun RecordView(
    modifier: Modifier = Modifier,
    isRecording: Boolean,
    onClickCancel: () -> Unit,
    onClickPause: () -> Unit,
    onClickSend: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.recording))

    val icon =
        animateIntAsState(
            targetValue = if (isRecording) R.drawable.icon_mic else R.drawable.icon_pause,
            label = ""
        )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme.colors.surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        LottieAnimation(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            composition = composition,
            iterations = LottieConstants.IterateForever,
            contentScale = ContentScale.Inside,
            isPlaying = isRecording
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable { onClickCancel() }
                    .padding(8.dp),
                painter = painterResource(R.drawable.icon_cancel),
                contentDescription = "",
                tint = Theme.colors.primary
            )
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable { onClickPause() }
                    .padding(8.dp),
                painter = painterResource(icon.value),
                contentDescription = "",
                tint = Theme.colors.primary
            )

            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable { onClickSend() }
                    .padding(8.dp),
                painter = painterResource(R.drawable.icon_send),
                contentDescription = "",
                tint = Theme.colors.primary
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecord() {
    RecordView(modifier = Modifier, isRecording = false, {}, {}, {})
}
