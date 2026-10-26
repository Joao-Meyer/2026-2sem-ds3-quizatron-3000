package com.aulasandroid.quizatron3000ds3t2sem2026.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    sessionViewModel: SessionViewModel
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text("Tela de inicio")

        val userName by sessionViewModel.userName.observeAsState("")

        OutlinedTextField(
            value = userName,
            onValueChange = {
                sessionViewModel.updateUserName(it)
            }
        )

        OutlinedButton(
            onClick = {
                navController
                    .navigate("questions")
            }
        ) {
            Text("Perguntas ->")
        }
    }
}