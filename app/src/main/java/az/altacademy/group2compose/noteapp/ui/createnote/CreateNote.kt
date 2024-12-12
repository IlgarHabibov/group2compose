package az.altacademy.group2compose.noteapp.ui.createnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.components.NoteInput
import az.altacademy.group2compose.noteapp.designsystem.components.RoundedIconButton
import az.altacademy.group2compose.noteapp.designsystem.components.StandardPageColumn
import az.altacademy.group2compose.noteapp.designsystem.styles.regular23
import az.altacademy.group2compose.noteapp.designsystem.styles.regular48
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme
import az.altacademy.group2compose.noteapp.ui.utils.UIState

@Composable
fun CreateNotePage(
    navController: NavHostController,
    viewModel: CreateNewNoteVM = hiltViewModel()
){
    StandardPageColumn {
        var title by remember {
            mutableStateOf("")
        }

        var note by remember {
            mutableStateOf("")
        }

        val state = viewModel.state.observeAsState().value
        OnStateChange(navController = navController, state = state)


        CreateNoteTopView(
            onBackButtonClick = {
                navController.popBackStack()
            },
            onSaveButtonClick = {
                viewModel.addNewNote(title, note)
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            NoteInput(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                onValueChange = {newText ->
                    title = newText
                },
                placeholderText = "Title",
                textStyle = regular48,
                singleLine = true

            )

            Spacer(modifier = Modifier.height(40.dp))

            NoteInput(
                modifier = Modifier.fillMaxWidth(),
                text = note,
                onValueChange = {newText ->
                    note = newText
                },
                placeholderText = "Type something...",
                textStyle = regular23,

            )
        }
    }
}

@Composable
private fun OnStateChange(
    navController: NavHostController,
    state: UIState<Boolean>?
){

    when(state){
        is UIState.Error -> {

        }
        UIState.Loading -> {

        }
        is UIState.Success -> {
            navController.popBackStack()
        }

        null -> {

        }
    }
}


@Composable
private fun CreateNoteTopView(
    onBackButtonClick: () -> Unit,
    onSaveButtonClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        RoundedIconButton(
            onClick = onBackButtonClick,
            iconResId = R.drawable.ic_back
        )

        Spacer(modifier = Modifier.weight(1f, true))

        RoundedIconButton(
            onClick = onSaveButtonClick,
            iconResId = R.drawable.ic_save
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun CreateNotePreview(){
    val mockNavController = TestNavHostController(LocalContext.current)
    Group2ComposeTheme {
        CreateNotePage(mockNavController)
    }
}