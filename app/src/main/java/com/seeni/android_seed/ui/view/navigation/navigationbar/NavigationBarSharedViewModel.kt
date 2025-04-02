package com.seeni.android_seed.ui.view.navigation.navigationbar

import com.seeni.android_seed.ui.view.base.BaseViewModel
import com.seeni.android_seed.ui.view.utils.singleSharedFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class NavigationBarSharedViewModel @Inject constructor() : BaseViewModel() {

    private val _bottomItem = singleSharedFlow<BottomNavigationBarItem>()
    val bottomItem = _bottomItem.asSharedFlow()

    fun onBottomItemClicked(bottomItem: BottomNavigationBarItem) = launch {
        _bottomItem.emit(bottomItem)
    }
}