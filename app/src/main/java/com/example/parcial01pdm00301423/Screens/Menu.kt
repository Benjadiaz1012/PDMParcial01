package com.example.parcial01pdm00301423.Screens

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)

enum class TipoProducto {
    PUPUSA,
    BEBIDA
}

@Composable
fun MainMenu(onNext: () -> Unit) {
    val pupusaImg =
        "https://comedera.com/wp-content/uploads/sites/9/2023/05/Pupusas-de-quesoshutterstock_1803502444.jpg"
    val cafeImg = "https://i.blogs.es/139e0f/cafe-americano2/840_560.jpeg"
    val chocoImg =
        "https://cocinaconcoqui.com/wp-content/uploads/2025/12/chocolate-calientecasero-500x500.jpg"
    val cocaImg =
        "https://d23esi1h40dfmi.cloudfront.net/wpcontent/uploads/2025/08/01124509/00732.jpg"
    val menu = listOf(
        Producto(1, "Pupusa de queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
        Producto(2, "Pupusa de frijol con queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
        Producto(3, "Pupusa revuelta", 1.00, pupusaImg, TipoProducto.PUPUSA),
        Producto(4, "Pupusa de chicharrón", 1.00, pupusaImg, TipoProducto.PUPUSA),
        Producto(5, "Pupusa de loroco con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
        Producto(6, "Pupusa de ayote", 0.75, pupusaImg, TipoProducto.PUPUSA),
        Producto(7, "Pupusa de espinaca", 0.85, pupusaImg, TipoProducto.PUPUSA),
        Producto(8, "Pupusa de jalapeño con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
        Producto(9, "Café", 1.00, cafeImg, TipoProducto.BEBIDA),
        Producto(10, "Chocolate", 1.50, chocoImg, TipoProducto.BEBIDA),
        Producto(11, "Coca-Cola", 1.25, cocaImg, TipoProducto.BEBIDA)
    )
    var pQ = 0
    var pFQ = 0
    var pR = 0
    var pC = 0
    val lista = rememberSaveable() { mutableStateListOf<Any>(menu) }
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.padding(innerPadding)) {
                Button(onClick = { pQ++ }) {
                    Text(text = "Pupusa de queso")
                }
                Text(text = menu[0].nombre, modifier = Modifier.padding(top = 40.dp))

            }
            Box(modifier = Modifier.padding(innerPadding)) {
                Button(onClick = { pFQ++ }) {
                    Text(text = "Pupusa de frijol con queso")
                }
                Text(text = menu[1].nombre, modifier = Modifier.padding(top = 60.dp))
            }
            Box(modifier = Modifier.padding(innerPadding)) {
                Button(onClick = { pR++ }) {
                    Text(text = "Pupusa de frijol con queso")
                }
                Text(text = menu[2].nombre, modifier = Modifier.padding(top = 80.dp))
            }
            Box(modifier = Modifier.padding(innerPadding)) {
                Button(onClick = { pC++ }) {
                    Text(text = "Pupusa de frijol con queso")
                }
                Text(text = menu[2].nombre, modifier = Modifier.padding(top = 80.dp))
            }
            }
        }
    }

