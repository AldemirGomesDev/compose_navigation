package br.com.aldemir.composenavigationeasier.viewmodel

import androidx.lifecycle.ViewModel
import br.com.aldemir.composenavigationeasier.navigation.NavigationActions
import br.com.aldemir.composenavigationeasier.navigation.NavigationDestinations
import br.com.aldemir.composenavigationeasier.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateToBack() {
        navigator.navigate(
            NavigationActions.NavigateToBack.navigateToBack(
                NavigationDestinations.secondScreen
            )
        )
    }
}