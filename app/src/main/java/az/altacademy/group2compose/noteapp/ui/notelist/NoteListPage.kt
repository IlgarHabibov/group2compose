package az.altacademy.group2compose.noteapp.ui.notelist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.data.model.NoteModel
import az.altacademy.group2compose.noteapp.designsystem.components.FloatButton
import az.altacademy.group2compose.noteapp.designsystem.components.NoteItemView
import az.altacademy.group2compose.noteapp.designsystem.components.RoundedIconButton
import az.altacademy.group2compose.noteapp.designsystem.components.StandardPageColumn
import az.altacademy.group2compose.noteapp.designsystem.styles.semiBold43
import az.altacademy.group2compose.noteapp.designsystem.styles.textColor
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme
import az.altacademy.group2compose.noteapp.navigation.Routes
import az.altacademy.group2compose.noteapp.ui.utils.UIState

@Composable
fun NoteListPage(
    navController: NavHostController,
    noteListVM: NoteListVM = hiltViewModel()
) {

    var showDialog by remember { mutableStateOf(false) }
    val state = noteListVM.state.observeAsState()

    LaunchedEffect(key1 = Unit) {
        noteListVM.getUserNotes()
    }

    StandardPageColumn {

        NoteListTopView(
            onInfoButtonClick = { showDialog = true }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
        ) {


            NoteContentView(
                uiState = state.value,
                onNoteClick = {
                    navController.navigate(Routes.EDIT_NOTE_PAGE)
                },
            )
            FloatButton(
                onClick = {
                    navController.navigate(Routes.CREATE_NOTE_PAGE)
                },
                iconResId = R.drawable.ic_add,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(text = "Dialog Title")
                },
                text = {
                    Text("This is a dialog message.")
                },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

    }

}

@Composable
private fun NoteListTopView(
    onInfoButtonClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Notes",
            modifier = Modifier.weight(1f, true),
            style = semiBold43,
            color = textColor
        )

        Spacer(modifier = Modifier.width(16.dp))

        RoundedIconButton(
            onClick = onInfoButtonClick,
            iconResId = R.drawable.ic_info
        )
    }
}


@Composable
private fun NoteContentView(
    uiState: UIState<List<NoteModel?>>?,
    onNoteClick: (NoteModel?) -> Unit,
    modifier: Modifier = Modifier
) {
    var isNavigating by remember { mutableStateOf(false) }

    when (uiState) {
        is UIState.Error -> {
            Log.d("asdasdasd", "error: ")
        }

        UIState.Loading -> {
            CircularProgressIndicator()
        }

        is UIState.Success -> {
            NoteListView(
                notes = uiState.data,
                onNoteClick = { note ->
                    if (!isNavigating) {
                        isNavigating = true
                        onNoteClick(note)
                    }
                },
                modifier = modifier
            )
        }

        null -> {
            Log.d("asdasdasd", "NoteContentView: ")
        }
    }
}


@Composable
private fun NoteListView(
    notes: List<NoteModel?>,
    onNoteClick: (NoteModel?) -> Unit,
    modifier: Modifier = Modifier
) {

    if (notes.isEmpty()) {
        Image(
            painter = painterResource(
                id = R.drawable.img_empty_notes
            ),
            contentDescription = "Empty Note",
            modifier = modifier
        )
    } else {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 25.dp),
            modifier = modifier.fillMaxSize()
        ) {
            notes.forEach { note ->
                item {
                    NoteItemView(
                        note = note,
                        onClick = onNoteClick
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
private fun NoteListPagePreview() {
    val mockNavController = TestNavHostController(LocalContext.current)
    Group2ComposeTheme {
        NoteListPage(mockNavController)
    }
}