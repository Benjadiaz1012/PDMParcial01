package com.example.parcial01pdm00301423.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.parcial01pdm00301423.Modelo.Producto
import com.example.parcial01pdm00301423.Modelo.menu


@Composable
fun MainMenu(onNext: (List<Producto>) -> Unit) {
    val orderedItems = remember { mutableStateListOf<Producto>() }

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(menu) { listas ->
                    Column(modifier = Modifier.padding()) {
                        Text(text = listas.nombre)
                        Text(text = "Precio: \$${listas.precio}")
                        Text(text = "Tipo: ${listas.tipo.name}")
                        AsyncImage(model = listas.imagenUrl, contentDescription = null)
                        Button(
                            onClick = { orderedItems.add(listas) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            Text(text = "Ordenar")
                        }
                    }
                }
            }
            Button(
                onClick = { onNext(orderedItems) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Ver mi Orden")
            }
        }
    }
}