package com.example.pomodorotimer.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerUseCase {
    private var job: Job? = null

    fun startTimer(
        durationMillis: Long,
        scope: CoroutineScope,
        onTick: (remainingMillis:Long) ->Unit,
        onFinish: () -> Unit
    ){
       job?.cancel()
       job = scope.launch{
           var remaining = durationMillis
           while (remaining >0){
               delay(1000)
               remaining -=1000
               onTick(remaining)
           }
           onFinish()
       }
    }

    fun stopTimer() {
        job?.cancel()
    }
}