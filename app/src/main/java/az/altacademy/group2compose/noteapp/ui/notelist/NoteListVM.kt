package az.altacademy.group2compose.noteapp.ui.notelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.altacademy.group2compose.noteapp.data.model.NoteModel
import az.altacademy.group2compose.noteapp.data.utils.NotesConstants
import az.altacademy.group2compose.noteapp.ui.utils.UIState
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListVM @Inject constructor(
    private val firestore: FirebaseFirestore
): ViewModel() {

    private val _state: MutableLiveData<UIState<List<NoteModel?>>> = MutableLiveData()
    val state: LiveData<UIState<List<NoteModel?>>> = _state

    fun getUserNotes() {

        viewModelScope.launch {
            firestore.collection(NotesConstants.NOTES)
//            .orderBy(NotesConstants.CREATED_AT, Query.Direction.DESCENDING)
                .addSnapshotListener { task, error ->
                    val documents = task?.documents
                    val mappedDocuments = documents?.map { document ->
                        val newDocument = document.toObject(NoteModel::class.java)
                        newDocument?.copy(id = document.id)
                    }
                    _state.value = UIState.Success(mappedDocuments.orEmpty())
//                    _state.value = UIState.Success(listOf())
                }
        }

    }
}