package com.example.parcial01pdm00301423

import android.view.Menu
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.parcial01pdm00301423.Screens.MainMenu
import com.example.parcial01pdm00301423.Screens.Orden

@Composable
fun basicoComposable() {
    val backStack = rememberNavBackStack(Route.MainMenu)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.MainMenu> {
                MainMenu(
                    onNext = {
                        backStack.add(Route.Orden)
                    }
                )
            }
            entry<Route.Orden> {
                Orden(
                    onNext = {
                        backStack.add(Route.MainMenu)
                    })
            }

        }
    )
}