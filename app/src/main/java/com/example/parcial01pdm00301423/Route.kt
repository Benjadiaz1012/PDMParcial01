package com.example.parcial01pdm00301423

import androidx.navigation3.runtime.NavKey
import com.example.parcial01pdm00301423.Modelo.Producto
import kotlinx.serialization.Serializable

@Serializable
sealed class Route : NavKey {
    @Serializable
    data object MainMenu : Route()

    @Serializable
    data object OrdenCompleta : Route()
}