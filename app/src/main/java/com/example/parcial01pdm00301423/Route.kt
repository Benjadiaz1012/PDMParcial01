package com.example.parcial01pdm00301423

import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Route : NavKey{

@Serializable
data object MainMenu: Route()
@Serializable
data object Orden: Route()
}