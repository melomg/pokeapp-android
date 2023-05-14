package com.melih.android.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.melih.android.pokeapp.core.designsystem.theme.PokeAppTheme
import com.melih.android.pokeapp.core.navigation.Routers
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var routers: Routers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokeAppTheme {
                MainScreen(routers = routers)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokeAppTheme {
        MainScreen(routers = emptyMap())
    }
}
