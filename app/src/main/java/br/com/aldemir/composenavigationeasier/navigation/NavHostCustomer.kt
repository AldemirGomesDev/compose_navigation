package br.com.aldemir.composenavigationeasier.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.aldemir.composenavigationeasier.model.SomeObject
import br.com.aldemir.composenavigationeasier.constants.Constants.SOME_OBJECT_PARAMETER
import br.com.aldemir.composenavigationeasier.extensions.asLifecycleAwareState
import br.com.aldemir.composenavigationeasier.screens.FirstScreen
import br.com.aldemir.composenavigationeasier.screens.SecondScreen
import br.com.aldemir.composenavigationeasier.screens.ThirdScreen
import br.com.aldemir.composenavigationeasier.viewmodel.FirstScreenViewModel
import com.google.gson.Gson

@Composable
fun NavHostExample(
    navController: NavHostController,
    viewModel: FirstScreenViewModel,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navigatorState by viewModel.navigator.navActions.asLifecycleAwareState(
        lifecycleOwner = lifecycleOwner,
        initialState = null
    )
    LaunchedEffect(navigatorState) {
        navigatorState?.let { navigationAction ->
            navController.navigate(navigationAction.destination, navigationAction.navOptions)
        }
    }

    NavHost(navController, startDestination = NavigationDestinations.firstScreen) {
        composable(route = NavigationDestinations.firstScreen) {
            FirstScreen(viewModel = viewModel)
        }

        composable(route = NavigationDestinations.secondScreen) {
            SecondScreen()
        }

        composable(
            route = "${NavigationDestinations.thirdScreen}/{someParcelableObject}",
            arguments = listOf(navArgument(SOME_OBJECT_PARAMETER) { type = NavType.StringType })
        ) { backStackEntry ->
            val someStringArgument = backStackEntry.arguments?.getString(SOME_OBJECT_PARAMETER)
            val someObject = Gson().fromJson(someStringArgument, SomeObject::class.java)

            ThirdScreen(someObject = someObject)
        }
    }
}

