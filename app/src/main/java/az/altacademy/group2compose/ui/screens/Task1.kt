package az.altacademy.group2compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.ui.theme.PurpleDark
import az.altacademy.group2compose.ui.theme.PurpleLight

@Composable
fun Task1(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleLight)
            .padding(40.dp)

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.dp)
                .weight(1f)
                .background(PurpleDark)

        ) {

        }
    }
}
