package az.altacademy.group2compose.noteapp.data.model

import com.google.firebase.firestore.FieldValue

data class NewNoteRequest(
    val id: String? = null,
    val title: String? = null,
    val note: String? = null,
    val createdAt: FieldValue? = null
)
