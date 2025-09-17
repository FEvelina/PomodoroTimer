package com.example.pomodorotimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pomodorotimer.ui.main.MainScreen
import com.example.pomodorotimer.ui.main.MainViewModel
import com.example.pomodorotimer.ui.theme.PomodoroTimerTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()




        setContent {
            MainScreen(viewModel)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PomodoroTimerTheme {
        Greeting("Android")
    }
}

//@Composable
//fun CardView(person: Person){
//    Card(
//        modifier = Modifier.fillMaxSize()
//            .padding(10.dp)
//    ) {
//        Row {
//
//
//            Image(
//                painter = painterResource(id = R.drawable.person_picture),
//                contentDescription = "Photo of person",
//                modifier = Modifier.width(100.dp)
//                    .height(100.dp)
//            )
//            Column {
//
//
//                Text(
//                    text = person.firstName,
//                    modifier = Modifier.padding(top = 16.dp)
//                )
//                Text(
//                    text = person.lastName,
//                    modifier = Modifier.padding(0.dp)
//                )
//                Text(
//                    text = person.age.toString(),
//                    modifier = Modifier.padding(0.dp)
//                )
//            }
//        }
//    }
//
//}