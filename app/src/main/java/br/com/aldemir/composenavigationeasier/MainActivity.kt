package br.com.aldemir.composenavigationeasier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.aldemir.composenavigationeasier.navigation.NavHostExample
import br.com.aldemir.composenavigationeasier.ui.theme.ComposeNavigationEasierTheme
import br.com.aldemir.composenavigationeasier.viewmodel.FirstScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: FirstScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationEasierTheme {
                NavHostExample(
                    navController = rememberNavController(),
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNavigationEasierTheme {
        Greeting("Android")
    }
}