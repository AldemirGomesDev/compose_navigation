package br.com.aldemir.composenavigationeasier.viewmodel

import androidx.lifecycle.ViewModel
import br.com.aldemir.composenavigationeasier.navigation.NavigationActions
import br.com.aldemir.composenavigationeasier.navigation.NavigationDestinations
import br.com.aldemir.composenavigationeasier.navigation.Navigator
import br.com.aldemir.composenavigationeasier.model.SomeObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateExample() {
        navigator.navigate(
            NavigationActions.SecondScreen.secondScreenToThirdScreen(
            SomeObject(
                "aldemir",
                "address"
            )
        ))
    }
    fun navigateToBack() {
        navigator.navigate(
            NavigationActions.NavigateToBack.navigateToBack(
                NavigationDestinations.firstScreen
            )
        )
    }
}