package az.altacademy.group2compose.noteapp.ui.editnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import az.altacademy.group2compose.R
import az.altacademy.group2compose.noteapp.designsystem.components.NoteInput
import az.altacademy.group2compose.noteapp.designsystem.components.RoundedIconButton
import az.altacademy.group2compose.noteapp.designsystem.components.StandardPageColumn
import az.altacademy.group2compose.noteapp.designsystem.styles.regular23
import az.altacademy.group2compose.noteapp.designsystem.styles.regular48
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun EditeNotePage(navController: NavHostController){
    StandardPageColumn {

        var isEditEnable by remember {
            mutableStateOf(false)
        }

        CreateNoteTopView(
            isEditEnable = isEditEnable,
            onBackButtonClick = {
                navController.popBackStack()
            },
            onEditSaveButtonClick = {
                isEditEnable = !isEditEnable
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
        ) {
            var title by remember {
                mutableStateOf("")
            }

            var note by remember {
                mutableStateOf("")
            }

            Spacer(modifier = Modifier.height(40.dp))

            NoteInput(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                onValueChange = {newText ->
                    title = newText
                },
                placeholderText = "Title",
                textStyle = regular48,
                singleLine = true,
                readOnly = !isEditEnable

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
                readOnly = !isEditEnable

            )
        }
    }
}


@Composable
private fun CreateNoteTopView(
    isEditEnable: Boolean,
    onBackButtonClick: () -> Unit,
    onEditSaveButtonClick: () -> Unit,
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
            onClick = onEditSaveButtonClick,
            iconResId = if (isEditEnable) R.drawable.ic_save else R.drawable.ic_edit
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun EditeNotePreview(){
    val mockNavController = TestNavHostController(LocalContext.current)
    Group2ComposeTheme {
        EditeNotePage(mockNavController)
    }
}