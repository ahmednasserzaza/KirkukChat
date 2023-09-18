package com.fighter.kirkukchat.presentation.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.presentation.ui.theme.Theme

@Composable
fun ChatAppBar(
    image: Painter,
    name: String,
    isOnline: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Theme.colors.primary)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_back),
            contentDescription = stringResource(R.string.icon_back_description),
            tint = Theme.colors.surface
        )
        UserInfo(image, name, isOnline)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.End),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_call),
                contentDescription = stringResource(R.string.icon_call),
                tint = Theme.colors.surface

            )
            Icon(
                painter = painterResource(id = R.drawable.icon_video_call),
                contentDescription = stringResource(R.string.icon_video_call),
                tint = Theme.colors.surface
            )
        }
    }
}

@Composable
private fun UserInfo(
    image: Painter,
    name: String,
    isOnline: Boolean
) {
    val userStatus = if (isOnline) stringResource(R.string.online) else ""
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = CircleShape),
                painter = image,
                contentDescription = stringResource(R.string.profile_image),
                contentScale = ContentScale.Crop
            )
            this@Row.AnimatedVisibility(visible = isOnline) {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(shape = CircleShape)
                        .background(Theme.colors.surface)
                        .padding(2.dp)
                        .clip(shape = CircleShape)
                        .background(Theme.colors.primary),
                    content = {}
                )
            }
        }

        Column {
            Text(
                text = name,
                style = Theme.typography.titleMedium,
                color = Theme.colors.surface,
            )
            Text(
                text = userStatus,
                style = Theme.typography.body,
                color = Theme.colors.surface,
            )
        }
    }
}

@Preview
@Composable
fun PreviewAppBar() {
    ChatAppBar(
        image = painterResource(id = R.drawable.profile_image),
        name = "Ahmed",
        isOnline = true
    )
}