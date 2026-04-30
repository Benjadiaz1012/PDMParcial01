package com.example.parcial01pdm00301423.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.parcial01pdm00301423.Modelo.Producto
import com.example.parcial01pdm00301423.Modelo.menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun Ordenes(ordenCompleta: MutableList<Producto>, onBack: () -> Unit) {

    var listaProductos by rememberSaveable { mutableStateOf(ordenCompleta.toList()) }

    val totalGeneral = listaProductos.sumOf { it.precio }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Orden Completa", modifier = Modifier.padding(16.dp))

            val nombresVistos = mutableListOf<String>()
            for (producto in listaProductos) {
                if (!nombresVistos.contains(producto.nombre)) {
                    nombresVistos.add(producto.nombre)
                }
            }

            for (nombre in nombresVistos) {

                var cantidad = 0
                for (p in listaProductos) {
                    if (p.nombre == nombre) {
                        cantidad = cantidad + 1
                    }
                }

                var precioUnitario = 0.0
                for (p in listaProductos) {
                    if (p.nombre == nombre) {
                        precioUnitario = p.precio
                        break
                    }
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "$nombre x$cantidad")
                    Text(text = "Precio unitario: \$$precioUnitario")
                    Text(text = "Subtotal: \$${precioUnitario * cantidad}")

                    Button(
                        onClick = {
                            val nuevaLista = mutableListOf<Producto>()
                            for (p in listaProductos) {
                                if (p.nombre != nombre) {
                                    nuevaLista.add(p)
                                }
                            }
                            listaProductos = nuevaLista
                            ordenCompleta.removeAll { it.nombre == nombre }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text(text = "Eliminar de la orden")
                    }
                }
            }

            Text(text = "Total: \$$totalGeneral", modifier = Modifier.padding(16.dp))

            Button(
                onClick = {
                    listaProductos = emptyList()
                    ordenCompleta.clear()
                    onBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Confirmar Orden")
            }

            Button(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Regresar al Menú")
            }
        }
    }
}