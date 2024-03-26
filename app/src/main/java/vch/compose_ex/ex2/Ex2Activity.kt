package vch.compose_ex.ex2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import vch.compose_ex.ex2.ui_ex2.navigation.AppNavigationGraph
import vch.compose_ex.ui.theme.Compose_exTheme
import vch.utilities.MyUtility

//https://www.youtube.com/watch?v=LFlobqW8Sy8&list=PLLwcRoh3a6u6IsUrXoKaoZNb5LvhOhV8J&index=21 1.30
//api key for https://newsapi.org/ -  e218a394b12e45b5aa737a24c3465f1f

@AndroidEntryPoint
class Ex2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            Compose_exTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color.White)
                ) {
                    AppEntryPoint()
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowPreview() {
    Compose_exTheme() {
        Surface(
            modifier = Modifier.fillMaxSize().background(Color.White)
        ) {
            AppEntryPoint()
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}
