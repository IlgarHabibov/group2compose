package az.altacademy.group2compose.lessons.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun MyButton() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(16.dp)
    ) {

        Button(
            modifier = Modifier
                ,
            onClick = {
                // do anything onClick
            },
            enabled = true,
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContentColor = Color.Red,
                disabledContainerColor = Color.LightGray
            ),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 18.dp,
                pressedElevation = 4.dp,
                disabledElevation = 0.dp
            ),
            interactionSource = remember { MutableInteractionSource() },
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )


        }

    }


}

@Preview(showBackground = true)
@Composable
fun Buttons() {
    Group2ComposeTheme {
        MyButton()
    }
}