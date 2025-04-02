package com.seeni.android_seed.ui.view.navigation

import androidx.navigation.NavHostController

class MainRouter(
    private val mainNavController: NavHostController
) {
    fun navigateProfile() {
        mainNavController.navigate(Page.Profile)
    }
}