package az.altacademy.group2compose.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme
import az.altacademy.group2compose.noteapp.navigation.NoteGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Group2ComposeTheme {
                NoteGraph()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun NoteActivityPreview() {
    Group2ComposeTheme {
        NoteGraph()
    }
}