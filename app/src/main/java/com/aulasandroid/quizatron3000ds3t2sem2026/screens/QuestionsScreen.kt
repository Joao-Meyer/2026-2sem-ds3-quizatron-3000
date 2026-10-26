package com.aulasandroid.quizatron3000ds3t2sem2026.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


data class Option (
    val text: String = "",
    val isCorrect: Boolean = false
)

data class Question (
    val statement: String = "",
    val options: List<Option> = listOf(),
)

@Composable
fun QuestionsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(modifier = modifier.fillMaxSize()) {
        val perguntas = listOf(
            Question(
                statement = "Qual a capital da frança?",
                options = listOf(
                    Option(
                        text = "Paris",
                        isCorrect = true
                    ),
                    Option(
                        text = "Osasco"
                    ),
                    Option(
                        text = "Londres"
                    ),
                    Option(
                        text = "Rio de Janeiro"
                    )
                )
            )
        )

        QuestionCard(question = perguntas[0])

        OutlinedButton(
            onClick = {
                navController
                    .navigate("result")
            }
        ) {
            Text("Resultado ->")
        }
    }
}

@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    question: Question
) {
    Column(modifier) {
        Text(question.statement)

        question.options.map { option ->
            val optionColor = if (option.isCorrect) Color.Green else Color.Red

            Text(
                text = option.text,
                color = optionColor
            )
        }
    }
}