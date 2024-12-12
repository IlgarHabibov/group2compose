package az.altacademy.group2compose.noteapp.ui.createnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.altacademy.group2compose.noteapp.data.model.NewNoteRequest
import az.altacademy.group2compose.noteapp.data.utils.NotesConstants
import az.altacademy.group2compose.noteapp.ui.utils.UIState
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateNewNoteVM @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _state: MutableLiveData<UIState<Boolean>> = MutableLiveData()
    val state: LiveData<UIState<Boolean>> = _state


    fun addNewNote(title: String, note: String) {
        firestore.collection(NotesConstants.NOTES)
            .add(
                NewNoteRequest(
                    title = title,
                    note = note,
                    createdAt = FieldValue.serverTimestamp()
                )
            ).addOnCompleteListener {task ->
                if (task.isSuccessful){
                    _state.value = UIState.Success(true)
                }

            }
            .addOnFailureListener {

            }
    }

}