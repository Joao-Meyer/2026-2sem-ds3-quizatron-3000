package com.aulasandroid.quizatron3000ds3t2sem2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aulasandroid.quizatron3000ds3t2sem2026.screens.QuestionsScreen
import com.aulasandroid.quizatron3000ds3t2sem2026.screens.ResultScreen
import com.aulasandroid.quizatron3000ds3t2sem2026.screens.SessionViewModel
import com.aulasandroid.quizatron3000ds3t2sem2026.screens.StartScreen
import com.aulasandroid.quizatron3000ds3t2sem2026.ui.theme.Quizatron3000Ds3t2sem2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quizatron3000Ds3t2sem2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    val sessionViewModel: SessionViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "questions"
                    ) {
                        composable( route = "start" ) {
                            StartScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                sessionViewModel = sessionViewModel
                            )
                        }

                            composable( route = "questions" ) {
                            QuestionsScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable( route = "result" ) {
                            ResultScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                sessionViewModel = sessionViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}