package com.seeni.android_seed.ui.view.utils

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {
    val networkState: Flow<NetworkState>
}

data class NetworkState(
    val isOnline: Boolean,
    val shouldRefresh: Boolean
)