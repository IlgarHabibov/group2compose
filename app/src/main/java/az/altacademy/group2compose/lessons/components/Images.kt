package az.altacademy.group2compose.lessons.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme
import coil.compose.AsyncImage


@Composable
fun MyImage(){

    Image(
        painter = painterResource(
            id = R.drawable.ic_add_circle
        ),
//        Icons.Default.Add,
        contentDescription = "My Image",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        alpha = 0.9f,
        colorFilter = ColorFilter.tint(
            color = Color.Cyan
        ),
        modifier = Modifier.size(240.dp, 170.dp).background(Color.Red)
    )


    AsyncImage(
        model = "image path",
        contentDescription = "loaded image",
        )

}

@Preview(showBackground = true)
@Composable
fun Images() {
    Group2ComposeTheme {
        MyImage()
    }
}