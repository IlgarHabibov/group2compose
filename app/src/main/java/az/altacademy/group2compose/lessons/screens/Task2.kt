package az.altacademy.group2compose.lessons.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.noteapp.designsystem.theme.PurpleDark
import az.altacademy.group2compose.noteapp.designsystem.theme.PurpleLight

@Composable
fun Task2(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleLight)
            .padding(40.dp)

    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }

        Spacer(modifier = Modifier.width(20.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }

        Spacer(modifier = Modifier.width(20.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }
    }
}
