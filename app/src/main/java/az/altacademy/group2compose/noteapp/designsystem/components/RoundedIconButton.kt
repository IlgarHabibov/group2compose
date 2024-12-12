package az.altacademy.group2compose.noteapp.designsystem.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.styles.actionColor
import az.altacademy.group2compose.noteapp.designsystem.styles.textColor
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun RoundedIconButton(
    onClick: () -> Unit,
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
    buttonBackground: Color = actionColor,
    contentColor: Color = textColor,
    cornerRadius: Dp = 15.dp
) = Button(
    modifier = modifier.sizeIn(
        maxHeight = 50.dp,
        maxWidth = 50.dp
    ),
    onClick = onClick,
    shape = RoundedCornerShape(cornerRadius),
    contentPadding = PaddingValues(
        horizontal = 13.dp,
        vertical = 13.dp
    ),
    colors = ButtonDefaults.buttonColors(
        containerColor = buttonBackground,
        contentColor = contentColor
    )

) {
    Icon(painter = painterResource(id = iconResId)
        ,
        contentDescription = "",
        modifier = Modifier.size(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Buttons() {
    Group2ComposeTheme {
        RoundedIconButton(
            onClick = {},
            iconResId = R.drawable.ic_edit
        )
    }
}