package az.altacademy.group2compose.noteapp.designsystem.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.styles.backgroundColor
import az.altacademy.group2compose.noteapp.designsystem.styles.textColor
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun FloatButton(
    onClick: () -> Unit,
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
    buttonBackground: Color = backgroundColor,

    ) =  Button(
    modifier = modifier,
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
        containerColor = buttonBackground,
        contentColor = textColor,
    ),
    contentPadding = PaddingValues(11.dp),
    shape = CircleShape,
    elevation = ButtonDefaults.elevatedButtonElevation(
        defaultElevation = 15.dp
    )


){

    Icon(
        painter = painterResource(
            id = iconResId
        ),
        contentDescription = "Add new note"
    )
}

@Preview(showBackground = true)
@Composable
fun FloatButtonPreview(){
    Group2ComposeTheme {
        FloatButton(onClick = {  }, iconResId = R.drawable.ic_add)
    }
}