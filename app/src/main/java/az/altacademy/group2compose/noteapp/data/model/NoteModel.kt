package az.altacademy.group2compose.noteapp.data.model

import com.google.firebase.Timestamp

data class NoteModel(
    val id: String? = null,
    val title: String? = null,
    val note: String? = null,
    val createdAt: Timestamp? = null
)
