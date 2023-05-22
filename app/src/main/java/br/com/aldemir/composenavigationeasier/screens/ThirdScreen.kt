package br.com.aldemir.composenavigationeasier.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.aldemir.composenavigationeasier.Greeting
import br.com.aldemir.composenavigationeasier.model.SomeObject
import br.com.aldemir.composenavigationeasier.viewmodel.ThirdScreenViewModel


@Composable
fun ThirdScreen(
    viewModel: ThirdScreenViewModel = hiltViewModel(),
    someObject: SomeObject?
) {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Greeting("Terceira tela : ${someObject}")
        Button(onClick = { viewModel.navigateToBack() }) {
            Text(text = "Voltar")
        }
    }

}