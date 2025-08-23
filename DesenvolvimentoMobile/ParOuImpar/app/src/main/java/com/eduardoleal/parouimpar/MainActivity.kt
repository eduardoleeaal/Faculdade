package com.eduardoleal.parouimpar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

fun resultado(escolhaJogador: Int) : String{
    // TODO
    // 0 - PAR
    // 1 - IMPAR
    val numero = Random.nextInt(0, 11)
    val venceu = (escolhaJogador == 0 && numero % 2 == 0) || (escolhaJogador == 1 && numero % 2 == 1)
    return when (escolhaJogador) {
        0, 1 -> "Valor roletado: $numero, Jogador ${if (venceu) "Venceu" else "Perdeu"}"
        else -> "Escolha incorreta"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutJogo()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutJogo()
}

@Composable
fun LayoutJogo() {

    var vencedor by remember { mutableStateOf("") }
    var escolhaJogador by remember { mutableIntStateOf(5) }
    var vitorias by remember { mutableIntStateOf(0)}
    var derrotas by remember { mutableIntStateOf(0) }
    var rodadas by remember { mutableIntStateOf(0) }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Par ou Ímpar", fontSize = 18.sp, fontWeight = Bold)

        Spacer(modifier = Modifier.height(15.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Center) {

            Button(modifier = Modifier.padding(10.dp, 0.dp),
                onClick = {
                    escolhaJogador = 0
                }) {
                Text(text = "Par")
            }

            Button(modifier = Modifier.padding(10.dp, 0.dp),
                onClick = {
                    escolhaJogador = 1
                }) {
                Text(text = "Ímpar")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        when (escolhaJogador) {
            0 -> {
                Text(text = "Você selecionou PAR", fontSize = 20.sp)
            }
            1 -> {
                Text(text = "Você selecionou ÍMPAR", fontSize = 20.sp)
            }
            else -> {
                Text(text = "")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                vencedor = resultado(escolhaJogador)
                rodadas++
                if ("Jogador Venceu" in vencedor) {
                    vitorias++
                } else if ("Jogador Perdeu" in vencedor) {
                    derrotas++
                }
            }) {
            Text(text = "Roletar")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = vencedor, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Resultados de $rodadas rodadas: ", fontSize = 20.sp)
        Text(text = "Jogador vencedor: $vitorias", fontSize = 20.sp)
        Text(text = "CPU vencedor: $derrotas", fontSize = 20.sp)
    }
}