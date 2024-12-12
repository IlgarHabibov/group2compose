package az.altacademy.group2compose.noteapp.designsystem.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import az.altacademy.group2compose.noteapp.designsystem.styles.backgroundColor
import az.altacademy.group2compose.noteapp.designsystem.styles.textColor
import az.altacademy.group2compose.noteapp.designsystem.styles.textHintColor

@Composable
fun NoteInput(
    text: String,
    placeholderText: String,
    textStyle: TextStyle,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
) = TextField(
    modifier = modifier,
    value = text,
    onValueChange = {newText ->
        onValueChange.invoke(newText)
    },
    placeholder = {
        Text(
            text = placeholderText,
            style = textStyle,
            color = textHintColor
        )
    },
    readOnly = readOnly,
    textStyle = textStyle,
    colors = TextFieldDefaults.colors(
        focusedContainerColor = backgroundColor,
        unfocusedContainerColor = backgroundColor,
        focusedTextColor = textColor,
        unfocusedTextColor = textColor,
        focusedIndicatorColor = backgroundColor,
        unfocusedIndicatorColor = backgroundColor,
        cursorColor = textHintColor

    ),
    singleLine = singleLine

)