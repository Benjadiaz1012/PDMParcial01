package com.example.parcial01pdm00301423

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.parcial01pdm00301423.Modelo.Producto
import com.example.parcial01pdm00301423.Screens.MainMenu
import com.example.parcial01pdm00301423.Screens.Ordenes

@Composable
fun cosas() {
    val backStack = rememberNavBackStack(Route.MainMenu)
    val orderedItems = remember { mutableListOf<Producto>() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Route.MainMenu> {
                MainMenu(
                    onNext = { nuevaOrden ->
                        orderedItems.clear()
                        orderedItems.addAll(nuevaOrden)
                        backStack.add(Route.OrdenCompleta)
                    }
                )
            }

            entry<Route.OrdenCompleta> {
                Ordenes(
                    ordenCompleta = orderedItems,
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}