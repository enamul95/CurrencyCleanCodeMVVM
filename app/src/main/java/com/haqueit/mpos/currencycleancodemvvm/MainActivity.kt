package com.haqueit.mpos.currencycleancodemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haqueit.mpos.currencycleancodemvvm.presentation.Screen
import com.haqueit.mpos.currencycleancodemvvm.presentation.coin_details.CoinDetailScreen
import com.haqueit.mpos.currencycleancodemvvm.presentation.coin_list.CoinListScreen
import com.haqueit.mpos.currencycleancodemvvm.presentation.ui.theme.CurrencyCleanCodeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //https://www.youtube.com/watch?v=EF33KmyprEQ
        //https://api.coinpaprika.com/v1/coins
        //https://api.coinpaprika.com/v1/coins/btc-bitcoin

        setContent {
            CurrencyCleanCodeMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {

                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route+"/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }


                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CurrencyCleanCodeMVVMTheme {
        Greeting("Android")
    }
}