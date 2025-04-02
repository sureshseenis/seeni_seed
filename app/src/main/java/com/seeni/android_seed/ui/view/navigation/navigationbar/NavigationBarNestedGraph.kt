package com.seeni.android_seed.ui.view.navigation.navigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.seeni.android_seed.ui.view.screens.HomeScreen
import com.seeni.android_seed.ui.view.navigation.Page
import com.seeni.android_seed.ui.view.screens.ProfileScreen
import com.seeni.android_seed.ui.view.utils.composableHorizontalSlide
import kotlin.reflect.KClass

@Composable
fun NavigationBarNestedGraph(
    navController: NavHostController,
    mainNavController: NavHostController,
    parentRoute: KClass<*>?
) {
    NavHost(
        navController = navController,
        startDestination = Page.Home,
        route = parentRoute
    ) {
        composableHorizontalSlide<Page.Home> { backStack ->
            HomeScreen()
        }

        composableHorizontalSlide<Page.Favourites> {
            ProfileScreen()
        }

        composableHorizontalSlide<Page.Profile> {
            ProfileScreen()
        }
    }
}