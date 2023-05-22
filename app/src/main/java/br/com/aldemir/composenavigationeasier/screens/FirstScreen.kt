package br.com.aldemir.composenavigationeasier.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.aldemir.composenavigationeasier.Greeting
import br.com.aldemir.composenavigationeasier.viewmodel.FirstScreenViewModel

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