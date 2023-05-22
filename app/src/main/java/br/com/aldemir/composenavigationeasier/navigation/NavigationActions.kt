package br.com.aldemir.composenavigationeasier.navigation

import androidx.navigation.NavOptions
import br.com.aldemir.composenavigationeasier.model.SomeObject
import com.google.gson.Gson

interface NavigationAction {
    val destination: String
    val navOptions: NavOptions
        get() = NavOptions.Builder().build()
}

object NavigationActions {
    object FirstScreen {
        fun firstScreenToSecondScreen() = object : NavigationAction {
            override val destination = NavigationDestinations.secondScreen
        }
    }

    object SecondScreen {
        fun secondScreenToThirdScreen(
            someObject: SomeObject
        ) = object : NavigationAction {
            override val destination = "${NavigationDestinations.thirdScreen}/${Gson().toJson(someObject)}"
            override val navOptions = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .build()
        }
    }

    object NavigateToBack {
        fun navigateToBack(destination: String) = object : NavigationAction {
            override val destination = destination
            override val navOptions = NavOptions.Builder()
                .setPopUpTo(destination, true)
                .setLaunchSingleTop(true)
                .build()
        }
    }
}