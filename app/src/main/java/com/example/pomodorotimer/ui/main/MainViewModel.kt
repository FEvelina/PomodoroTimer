package com.example.pomodorotimer.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pomodorotimer.domain.TimerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val timerUseCase: TimerUseCase = TimerUseCase()
) : ViewModel() {
    private val _timeLeft = MutableStateFlow("00:00")
    val timeLeft: StateFlow<String> = _timeLeft

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    fun startSession(minutes: Int){
      val totalMillis = minutes * 60 * 1000L
        _isRunning.value = true
        timerUseCase.startTimer(
            durationMillis = totalMillis,
            scope = viewModelScope,  //ties to lifecycle
            onTick = {millis ->
                _timeLeft.value = formatTime(millis) //update state
            },
            onFinish = {
                _isRunning.value = false //session ended
            }
        )
    }

    fun stopSession() {
        timerUseCase.stopTimer()
        _isRunning.value = false
    }

    private fun formatTime(millis: Long): String {
        val minutes = (millis / 1000) / 60
        val seconds = (millis / 1000) % 60
        return "%02d:%02d".format(minutes, seconds)
    }
}


