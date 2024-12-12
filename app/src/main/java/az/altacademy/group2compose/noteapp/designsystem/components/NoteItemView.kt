package az.altacademy.group2compose.noteapp.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import az.altacademy.group2compose.noteapp.data.model.NoteModel
import az.altacademy.group2compose.noteapp.designsystem.styles.itemBackgroundColor
import az.altacademy.group2compose.noteapp.designsystem.styles.regular25
import az.altacademy.group2compose.noteapp.designsystem.styles.textColorDark
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme

@Composable
fun NoteItemView(
    note: NoteModel?,
    onClick: (NoteModel?) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = {
            onClick.invoke(note)
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            focusedElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            disabledElevation = 0.dp,
            draggedElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = itemBackgroundColor
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = note?.title.orEmpty(),
            style = regular25,
            color = textColorDark,
            modifier = Modifier.fillMaxWidth()
            .padding(vertical = 27.dp, horizontal = 40.dp)
        )
        
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteItemViewPreview(){
    Group2ComposeTheme {
        NoteItemView(
            note = NoteModel(title = "New note"),
            onClick = {

            }
        )
    }
}