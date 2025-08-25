package com.eduardo.atividadeavaliativa01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Anotacao(
    val id: Long,
    val titulo: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaInicial()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout() {
    TelaInicial()
}

@Composable
fun TelaInicial() {
    val context = LocalContext.current
    val listaItens = remember { mutableStateListOf<Anotacao>() }
    var entrada by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)) {

        Text(text = "Bloco de notas", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(15.dp))

        Row (modifier = Modifier.padding(1.dp),
            verticalAlignment = Alignment.CenterVertically){
            TextField(value = entrada,
                onValueChange = { entrada = it },
                label = { Text(text = "Digite aqui") }
            )

            Button(modifier = Modifier.padding(5.dp, 0.dp),
                onClick = {
                    val titulo = entrada.trim()
                    if (titulo.isNotEmpty()) {
                        val item = Anotacao(
                            id = System.currentTimeMillis(),
                            titulo = titulo
                        )
                        listaItens.add(item)
                        entrada = ""
                        return@Button
                    }
                    Toast.makeText(context, "Título Incorreto", Toast.LENGTH_SHORT).show()
                }) { Text(text = "+") }
        }
        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(listaItens, key = { it.id }) { anotacao ->
                ItemNota(
                    anotacao = anotacao,
                    onDelete = { listaItens.remove(anotacao) }
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(modifier = Modifier.fillMaxWidth(),
            enabled = listaItens.isNotEmpty(),
            onClick = {

                listaItens.clear() // limpando a lista de itens de compra, a lazy colum
                // será atualziada automaticamente
                entrada = ""

            },) {

            Text(text = "Apagar Tudo", fontSize = 15.sp)

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemNota(
    anotacao: Anotacao,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxSize()
            .then(
                Modifier
                    .padding(vertical = 4.dp)
                    .combinedClickable(
                        onClick = {},
                        onLongClick = { onDelete() }
                    )
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = anotacao.titulo,
            fontSize = 14.sp
        )
    }
}