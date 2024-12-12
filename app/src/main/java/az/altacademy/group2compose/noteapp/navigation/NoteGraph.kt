package az.altacademy.group2compose.noteapp.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import az.altacademy.group2compose.noteapp.ui.createnote.CreateNotePage
import az.altacademy.group2compose.noteapp.ui.editnote.EditeNotePage
import az.altacademy.group2compose.noteapp.ui.notelist.NoteListPage

@Composable
fun NoteGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NOTE_LIST_PAGE,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth })
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth })
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth })
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
        }
    ) {
        composable(Routes.NOTE_LIST_PAGE) { NoteListPage(navController) }
        composable(Routes.CREATE_NOTE_PAGE) { CreateNotePage(navController) }
        composable(Routes.EDIT_NOTE_PAGE) { EditeNotePage(navController) }
    }
}