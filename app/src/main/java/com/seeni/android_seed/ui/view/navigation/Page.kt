package com.seeni.android_seed.ui.view.navigation

import kotlinx.serialization.Serializable

sealed class Page {
    @Serializable
    data object NavigationBar : Page()

    @Serializable
    data object Home : Page()

    @Serializable
    data object Profile : Page()

    @Serializable
    data object Favourites: Page()

    @Serializable
    data object Services: Page()

    @Serializable
    data object Notification: Page()
}

sealed class Graph {
    @Serializable
    data object Main : Graph()
}

fun Page.route(): String? {
    return this.javaClass.canonicalName
}