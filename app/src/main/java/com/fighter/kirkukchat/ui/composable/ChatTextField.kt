package com.fighter.kirkukchat.ui.composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        onValueChange = onValueChanged,
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = textPlaceHolder) },
        colors = TextFieldDefaults.textFieldColors(textColor = Theme.colors.contentBorder),
        textStyle = Theme.typography.titleMedium,
        singleLine = true,
    )
}

@Preview
@Composable
fun PreviewChatTextField() {
    var newValue = ""
    ChatTextField(onValueChanged = { value -> newValue = value }, value = newValue)
}