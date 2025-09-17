package com.example.pomodorotimer.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val timeLeft by viewModel.timeLeft.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(timeLeft, fontSize = 48.sp)

        Spacer(Modifier.height(16.dp))


        if (!isRunning){
            Button(onClick = { viewModel.startSession(25) }) {
                Text("Study for 25 minutes")
            }
            } else {
                Button(onClick = {viewModel.stopSession()}) {
                    Text("Stop")
                }
            }

        }
    }


