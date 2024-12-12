package az.altacademy.group2compose.lessons.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.altacademy.group2compose.noteapp.designsystem.theme.Group2ComposeTheme



@Composable
fun SettingsPage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                16.dp
            )
    ) {
        val menuList = createSettingsList()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            menuList.forEachIndexed(){ index, menuItem ->
                when (index ){
                    0 -> item {
                        SettingsHeader(text = "Group 1")
                    }
                    2 -> item {
                        SettingsHeader(text = "Group 2")
                    }
                    4 -> item {
                        SettingsHeader(text = "Group 3")
                    }
                }
                item {
                    SettingsItem(text = menuItem.text, icon = menuItem.icon)
                }
            }
        }
    }
}

@Composable
fun SettingsItem(text: String, icon: ImageVector){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$text icon",
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Composable
fun SettingsHeader(text: String){
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
    )
}


fun createSettingsList() = listOf(
    //Group1
    SettingsItemModel(text = "Profile", Icons.Default.AccountCircle),
    SettingsItemModel(text = "Favorite", Icons.Default.Favorite),

    //Group 2
    SettingsItemModel(text = "Map", Icons.Default.Place),
    SettingsItemModel(text = "Call Center", Icons.Default.Call),

    // Group 3
    SettingsItemModel(text = "About Us", Icons.Default.Info),
    SettingsItemModel(text = "Share", Icons.Default.Share),
    SettingsItemModel(text = "Rate Us", Icons.Default.Star),
)

data class SettingsItemModel(
    val text: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun SettingsPagePreview(){
    Group2ComposeTheme {

    }
}