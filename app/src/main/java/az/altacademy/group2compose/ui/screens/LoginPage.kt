package az.altacademy.group2compose.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.altacademy.group2compose.ui.theme.Group2ComposeTheme


@Composable
fun LoginPage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var email by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            label = {
                Text(text = "Label")
            },
            value = email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),

            onValueChange = {newValue -> email = newValue},
            placeholder = { PlaceHolderText(text = "Email")}
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = password,
            keyboardActions = KeyboardActions(
                onNext = {}
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            onValueChange = {newValue -> password = newValue},
            singleLine = true,
            placeholder = { PlaceHolderText(text = "Password")},
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                // do anything onClick
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.LightGray
            ),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp,
                disabledElevation = 0.dp
            ),
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Text(text = "Login")

        }

    }
}

@Composable
fun PlaceHolderText(text: String){
    Text(
        text = text,
        style = inputTextStyle,
        color = Color.DarkGray
    )
}

val inputTextStyle = TextStyle(
    color = Color.Black,
    fontSize = 16.sp
)

@Preview(showBackground = true)
@Composable
fun LoginPagePreview(){
    Group2ComposeTheme {
        LoginPage()
    }
}