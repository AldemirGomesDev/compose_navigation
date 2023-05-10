package br.com.aldemir.composenavigationeasier

import android.os.Parcelable
import androidx.navigation.NavOptions


object NavigationDestinations {
    const val firstScreen = "firstScreen"
    const val secondScreen = "secondScreen"
    const val thirdScreen = "thirdScreen"
}

interface NavigationAction {
    val destination: String
    val parcelableArguments: Map<String, Parcelable>
        get() = emptyMap()                              // No parcelable arguments as default
    val navOptions: NavOptions
        get() = NavOptions.Builder().build()            // No NavOptions as default
}

object NavigationActions {
    object FirstScreen {
        fun firstScreenToSecondScreen() = object : NavigationAction {
            override val destination = NavigationDestinations.secondScreen
        }
    }

    object SecondScreen {
        fun secondScreenToThirdScreen(
            someStringArgument: String,
            someParcelableObject: SomeParcelableClass
        ) = object : NavigationAction {
            override val destination = "${NavigationDestinations.thirdScreen}/$someStringArgument"
            override val parcelableArguments: Map<String, Parcelable>
                get() = mapOf("firstArg" to someParcelableObject)
            override val navOptions = NavOptions.Builder()
                .setPopUpTo(0, true)
                .setLaunchSingleTop(true)
                .build()
        }
    }
}