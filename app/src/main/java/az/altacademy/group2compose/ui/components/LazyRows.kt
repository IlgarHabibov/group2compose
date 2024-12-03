package az.altacademy.group2compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.ui.theme.Group2ComposeTheme

@Composable
fun MyLazyRow() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(50) { index ->
                Text(
                    text = "Item #$index",
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LazyRows() {
    Group2ComposeTheme {
        MyLazyRow()
    }
}