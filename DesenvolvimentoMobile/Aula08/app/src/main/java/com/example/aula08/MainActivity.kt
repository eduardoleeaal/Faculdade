package com.example.aula08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

data class ItemLista(val id: Int, val nome: String, val marcado: Boolean = false)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeCompras()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout() {
    ListaDeCompras()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeCompras() {
    var texto by remember { mutableStateOf("") }
    val itensLista = remember { mutableStateListOf<ItemLista>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de compras", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = texto,
                onValueChange = { texto = it },
                singleLine = true,
                label = { Text(text = "Novo Item") })

            Button(
                onClick = {
                    val nomeItem = texto.trim()
                    if (nomeItem.isNotEmpty() && !(itensLista.any { it.nome == nomeItem })) {
                        val id = Random.nextInt(10000)
                        itensLista.add(ItemLista(id, nomeItem))
                        texto = "" // Limpando textos
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "+", fontSize = 25.sp)
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { itensLista.clear() },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Limpar Lista")
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(itensLista, key = { it.id }) { item ->
                ItensDaLista(
                    item = item,
                    onToggle = { target ->
                        val i = itensLista.indexOfFirst { it.id == target.id }
                        if (i != -1) {
                            itensLista[i] = itensLista[i].copy(marcado = !target.marcado)
                        }
                    },
                    onDelete = { target ->
                        itensLista.removeIf { it.id == target.id }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItensDaLista(
    item: ItemLista,
    onToggle: (ItemLista) -> Unit,
    onDelete: (ItemLista) -> Unit
) {
    val decoracao = if (item.marcado) TextDecoration.LineThrough else TextDecoration.None

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onToggle(item) },
                onLongClick = { onDelete(item) }
            )
            .padding(5.dp)

    ) {
        Text(text = item.nome, textDecoration = decoracao, fontSize = 20.sp)
    }
}
