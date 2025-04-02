package com.seeni.android_seed.ui.view.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

interface DispatchersProvider {
    val io: CoroutineDispatcher
    val main: MainCoroutineDispatcher
    val default: CoroutineDispatcher
}