package az.altacademy.group2compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import az.altacademy.group2compose.ui.theme.Group2ComposeTheme
import az.altacademy.group2compose.ui.theme.robotoNew

@Composable
fun MyText(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Hello Kotlin! asd asdada s das das dasd asdas dasd",
            letterSpacing = 1.sp,
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = medium_14_16,
            textDecoration = TextDecoration.Underline,
            overflow = TextOverflow.Visible,
            softWrap = true,
            onTextLayout = {text ->

            },
            modifier = Modifier.fillMaxWidth()
        )

    }
}

val medium_14_16 = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
    lineHeight = 140.sp
)

@Preview(showBackground = true)
@Composable
fun Texts() {
    Group2ComposeTheme {
        MyText()
    }
}
