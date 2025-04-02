package com.seeni.android_seed.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.seeni.android_seed.ui.view.navigation.navigationbar.NavigationBarNestedGraph
import com.seeni.android_seed.ui.view.screens.HomeScreen
import com.seeni.android_seed.ui.view.navigation.navigationbar.NavigationBarScreen
import com.seeni.android_seed.ui.view.screens.ProfileScreen
import com.seeni.android_seed.ui.view.utils.composableHorizontalSlide
import com.seeni.android_seed.ui.view.utils.sharedViewModel

@Composable
fun MainGraph(
    mainNavController: NavHostController,
    darkMode: Boolean,
    onThemeUpdated: () -> Unit
) {
    NavHost(
        navController = mainNavController,
        startDestination = Page.NavigationBar,
        route = Graph.Main::class
    ) {
        composableHorizontalSlide<Page.NavigationBar> { backStack ->
            val nestedNavController = rememberNavController()
            NavigationBarScreen(
                sharedViewModel = backStack.sharedViewModel(navController = mainNavController),
                mainRouter = MainRouter(mainNavController),
                darkMode = darkMode,
                onThemeUpdated = onThemeUpdated,
                nestedNavController = nestedNavController
            ) {
                NavigationBarNestedGraph(
                    navController = nestedNavController,
                    mainNavController = mainNavController,
                    parentRoute = Graph.Main::class
                )
            }
        }

        composableHorizontalSlide<Page.Home> {
            HomeScreen()
        }

        composableHorizontalSlide<Page.Profile> {
            ProfileScreen()
        }
    }
}