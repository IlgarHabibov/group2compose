package az.altacademy.group2compose.lessons.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun MyTextField() {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
        },
        enabled = true,
        readOnly = false,
        placeholder = {
            Text(text = "Placeholder")
                      },
        label = {
            Text(text = "Label")
                },
        leadingIcon = {
            Icon(Icons.Default.AccountCircle, "")
                      },
        trailingIcon = {
            Icon(Icons.Default.Check, "")
                       },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(onDone = {}),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(color = Color.Black),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Red,
            unfocusedTextColor = Color.Green,

        )
    )

}

@Preview(showBackground = true)
@Composable
fun TextFields() {
    Group2ComposeTheme {
        MyTextField()
    }
}