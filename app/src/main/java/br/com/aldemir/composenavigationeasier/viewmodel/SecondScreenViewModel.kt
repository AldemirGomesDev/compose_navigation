package br.com.aldemir.composenavigationeasier.viewmodel

import androidx.lifecycle.ViewModel
import br.com.aldemir.composenavigationeasier.NavigationActions
import br.com.aldemir.composenavigationeasier.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateExample() {
        navigator.navigate(NavigationActions.FirstScreen.firstScreenToSecondScreen())
    }
}