package br.com.aldemir.composenavigationeasier

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


interface Navigator {
    val navActions: StateFlow<NavigationAction?>
    fun navigate(navAction: NavigationAction?)
}

class ComposeCustomNavigator @Inject constructor() : Navigator {
    private val _navActions: MutableStateFlow<NavigationAction?> by lazy {
        MutableStateFlow(null)
    }
    override val navActions = _navActions.asStateFlow()

    override fun navigate(navAction: NavigationAction?) {
        Log.w("TAG_navigator", "navigate: $navAction")
        _navActions.update { navAction }
    }
}