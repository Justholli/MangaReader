package com.jh.mangareader.authorization.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jh.mangareader.authorization.ui.screen.destinations.MainScreenDestination
import com.jh.mangareader.authorization.ui.viewmodel.AuthorizationViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination(start = true)
@Composable
fun AuthScreen(
    viewModel: AuthorizationViewModel = viewModel(),
    navigator: DestinationsNavigator
) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = viewModel.text)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                      navigator.navigate(
                          MainScreenDestination("Misha")
                      )
            },
            Modifier.align(Alignment.End)
        ) {
            Text(text = "To Main Screen")
        }
    }
}