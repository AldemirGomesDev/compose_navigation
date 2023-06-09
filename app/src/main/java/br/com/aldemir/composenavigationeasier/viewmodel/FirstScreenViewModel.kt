package br.com.aldemir.composenavigationeasier.viewmodel

import androidx.lifecycle.ViewModel
import br.com.aldemir.composenavigationeasier.navigation.NavigationActions
import br.com.aldemir.composenavigationeasier.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    val navigator: Navigator
) : ViewModel() {

    fun navigateExample() {
        navigator.navigate(NavigationActions.FirstScreen.firstScreenToSecondScreen())
    }
}