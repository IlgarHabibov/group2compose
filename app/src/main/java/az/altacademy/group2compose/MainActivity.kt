package az.altacademy.group2compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.altacademy.group2compose.ui.screens.LoginPage
import az.altacademy.group2compose.ui.screens.SettingsPage
import az.altacademy.group2compose.ui.screens.Task1
import az.altacademy.group2compose.ui.screens.Task2
import az.altacademy.group2compose.ui.theme.Group2ComposeTheme
import az.altacademy.group2compose.ui.theme.PurpleDark
import az.altacademy.group2compose.ui.theme.PurpleLight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SettingsPage()
        }
    }
}

@Composable
fun FirstScreen(onClick: (() -> Unit)?) {
    Column(modifier = Modifier.fillMaxSize()) {
//        KotlinRow()
//        AndroidColumn()
//        ProgrammingBox()
//        SpaceTest()
//        Task1()
//        Task2()
//        RecyclerViewTest(list = creatList())
        ShapesTest(
            onClick = onClick
        )
    }
}

@Composable
fun ProgrammingBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Programming2",
            modifier = Modifier
                .size(240.dp)
                .background(Color.Blue)
        )
        Text(
            text = "Programming1",
            modifier = Modifier
                .size(140.dp)
                .background(Color.Red)
        )

    }
}

@Composable
fun SpaceTest() {
    Row(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.width(50.dp))
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.Cyan)
        ) {

        }

        Spacer(modifier = Modifier.width(50.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.Cyan)
        ) {

        }

        Spacer(modifier = Modifier.width(50.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.Cyan)
        ) {

        }
    }
}


@Composable
fun RecyclerViewTest(list: List<String>) {
    LazyColumn {
        list.forEach { item ->
            item {
                Text(
                    text = item,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)

                )
            }
        }
    }
}


@Composable
fun ShapesTest(onClick: (() -> Unit)?){
   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(16.dp)
   ) {

       Text(
           text = "Kotlin",
           fontSize = 22.sp,
           modifier = Modifier
               .shadow(elevation = 12.dp, shape = RoundedCornerShape(20.dp))
               .border(
                   width = 2.dp,
                   color = Color.Red,
                   shape = RoundedCornerShape(20.dp)
               )
               .clip(RoundedCornerShape(20.dp))
               .background(Color.Green)
               .draggable(
                   orientation = Orientation.Vertical,
                   state = rememberDraggableState {

                   }
               )
               .padding(50.dp)


       )
   }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Group2ComposeTheme {
        FirstScreen(null)
    }
}


fun creatList() = listOf(
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "10",
    "11",
    "12",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
    "13",
)