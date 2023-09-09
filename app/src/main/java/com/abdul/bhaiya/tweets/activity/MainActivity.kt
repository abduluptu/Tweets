package com.abdul.bhaiya.tweets.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abdul.bhaiya.tweets.screens.CategoryScreen
import com.abdul.bhaiya.tweets.screens.DetailScreen
import com.abdul.bhaiya.tweets.ui.theme.TweetsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //test code
    /* @Inject
     lateinit var tweetsAPI: TweetsAPI*/

    @OptIn(DelicateCoroutinesApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //test code
        /* GlobalScope.launch {
             val response = tweetsAPI.getCategories()
             Log.d("SOHA", response.body()!!.distinct().toString())
         }*/

        setContent {
            TweetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // App()
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Tweets", color = Color.White)
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
                            )
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            App()
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun App() {
        /*  //NavController
          val navController = rememberNavController()
          //NavHost
          NavHost(navController = navController, startDestination = "categoty") {
              //NavGraph
              composable(route = "categoty"){
                  CategoryScreen{
                      navController.navigate("detail/${it}")
                  }
              }

              composable(route = "detail/{categoty}",
                  arguments= listOf(
                      navArgument("category"){
                          type = NavType.StringType
                      }
                  )
              ){
                  DetailScreen()
              }
          }*/

        //NavController
        val navController = rememberNavController()
        //NavHost
        NavHost(navController = navController, startDestination = "category") {
            //NavGraph
            composable(route = "category") {
                CategoryScreen {
                    navController.navigate("detail/${it}")
                }
            }
            composable(route = "detail/{category}",
                arguments = listOf(
                    navArgument("category") {
                        type = NavType.StringType
                    }
                )
            ) {
                DetailScreen()
            }
        }
    }
}

//Dummy code for Navigation
/*@Composable
fun App() {
    //NavController
    val navController = rememberNavController()
    //NavHost
    NavHost(navController = navController, startDestination = "registration") {
        //NavGraph
        composable(route = "registration") {
            //option1: NavController (for click)
            //RegistrationScreen(navController)

            //option2: function (for click)
            RegistrationScreen {
                navController.navigate("main/${it}") //map below-> "main/{email}"
            }
        }

        composable(route = "login") {
            LoginScreen()
        }

        //get data from Registration Screen
        composable(route = "main/{email}", arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            }
        )) {
            //read value, passed by registration screen
           val email =  it.arguments!!.getString("email")
            MainScreen(email!!)
        }
    }
}*/

/*@Composable
//fun RegistrationScreen(navController: NavController) { //option1
fun RegistrationScreen(onClick: (email: String) -> Unit) { //onClick->1
    Text(text = "Registration",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable { //implement click event
            //option1
            // navController.navigate("main")
            //option2
            onClick("abdulappindia@gmail.com") //onClick->2
        }
    )
}

@Composable
fun LoginScreen() {
    Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun MainScreen(email: String) {
    Text(text = "Main Screen- $email", style = MaterialTheme.typography.headlineLarge)
}*/

