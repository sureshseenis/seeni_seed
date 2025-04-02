package com.seeni.android_seed.ui.view.navigation.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.seeni.android_seed.ui.view.navigation.Page

data class NavigationBarUiState(
    val bottomItems: List<BottomNavigationBarItem> = listOf(
        BottomNavigationBarItem.Home,
        BottomNavigationBarItem.Favorites,
        BottomNavigationBarItem.Notifications,
        BottomNavigationBarItem.Services
    )
)

sealed class BottomNavigationBarItem(
    val tabName: String,
    val imageVector: ImageVector,
    val page: Page,
) {
    data object Home : BottomNavigationBarItem("Home", imageVector = Icons.Default.Home, Page.Home)
    data object Favorites : BottomNavigationBarItem("Chat", imageVector = Icons.Default.Email, Page.Favourites)
    data object Notifications : BottomNavigationBarItem("Notifications", imageVector = Icons.Default.Notifications, Page.Notification)
    data object Services : BottomNavigationBarItem("Services", imageVector = Icons.Default.Add, Page.Services)
}
