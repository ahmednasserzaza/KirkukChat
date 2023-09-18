package com.fighter.kirkukchat.ui.composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.kirkukchat.R
import com.fighter.kirkukchat.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textPlaceHolder: String = stringResource(R.string.start_typing)
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChanged(it) },
        shape = RoundedCornerShape(24.dp),
        placeholder = { Text(text = textPlaceHolder) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Theme.colors.contentPrimary,
            disabledTextColor = Color.Transparent,
            containerColor = Theme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Theme.colors.contentTertiary
        ),
        textStyle = Theme.typography.titleMedium,
        singleLine = true,
    )
}

@Preview
@Composable
fun PreviewChatTextField() {
    var textValue by remember { mutableStateOf("") }
    ChatTextField(onValueChanged = { value -> textValue = value }, value = textValue)
}