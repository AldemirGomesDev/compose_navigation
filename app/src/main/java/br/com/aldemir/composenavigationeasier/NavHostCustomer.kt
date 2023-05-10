@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.aldemir.composenavigationeasier

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.aldemir.composenavigationeasier.extensions.asLifecycleAwareState
import br.com.aldemir.composenavigationeasier.viewmodel.FirstScreenViewModel
import br.com.aldemir.composenavigationeasier.viewmodel.SecondScreenViewModel
import br.com.aldemir.composenavigationeasier.viewmodel.ThirdScreenViewModel
import javax.inject.Inject

@Composable
fun NavHostExample(
    navController: NavHostController = rememberNavController(),
    viewModel: FirstScreenViewModel,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navigatorState by viewModel.navigator.navActions.collectAsState()
    Log.w("TAG_navigator", "navigatorState: $navigatorState")
    LaunchedEffect(navigatorState) {
        Log.w("TAG_navigator", "NavHostExample: ${navigatorState}")
        navigatorState?.let {
            it.parcelableArguments.forEach { arg ->
                navController.currentBackStackEntry?.arguments?.putParcelable(arg.key, arg.value)
            }
            navController.navigate(it.destination, it.navOptions)
        }
    }

    NavHost(navController, startDestination = NavigationDestinations.firstScreen) {
        composable(route = NavigationDestinations.firstScreen) {
            FirstScreen()
        }

        composable(route = NavigationDestinations.secondScreen) {
            SecondScreen()
        }

        composable(
            route = "${NavigationDestinations.thirdScreen}/{someStringArgument}",
            arguments = listOf(navArgument("someStringArgument") { type = NavType.StringType })
        ) { backStackEntry ->
            val someStringArgument = backStackEntry.arguments?.getString("someStringArgument")
            val someParcelableObject =
                navController.previousBackStackEntry?.arguments?.getParcelable<SomeParcelableClass>(
                    "firstArg"
                )
            ThirdScreen(
                someStringArgument = someStringArgument!!,
                someParcelableObject = someParcelableObject!!
            )
        }
    }
}

@Composable
fun FirstScreen(
    viewModel: FirstScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Greeting("Android")
        Button(onClick = { viewModel.navigateExample() }) {
            Text(text = "Abrir segunda tela")
        }
    }
}

@Composable
fun SecondScreen(
    viewModel: SecondScreenViewModel = hiltViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Segunda tela")
    }
}

@Composable
fun ThirdScreen(
    viewModel: ThirdScreenViewModel = hiltViewModel(),
    someStringArgument: String,
    someParcelableObject: SomeParcelableClass
) {

}