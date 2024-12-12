package az.altacademy.group2compose.noteapp.ui.utils

sealed class UIState<out T> {
    data class Success<T>(val data: T): UIState<T>()
    data object Loading: UIState<Nothing>()
    data class Error(val errorCode: Int?, val errorMessage: String?): UIState<Nothing>()
}