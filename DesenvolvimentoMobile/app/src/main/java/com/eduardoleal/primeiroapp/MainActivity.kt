package com.eduardoleal.primeiroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardoleal.primeiroapp.ui.theme.PrimeiroAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaExemploTextField()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    TelaExemploTextField()
}

@Composable
fun TelaPrincipal() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Saudacao(texto = "Eduardo")
    }
}

@Composable
fun Saudacao(texto: String) {

    Text(
        text = "Olá, $texto!\nEste é meu primeiro App",
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )

}

@Composable
fun TelaBotaoExemplo() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        BotaoExemplo1()
    }
}

@Composable
fun BotaoExemplo1() {
    var clicado by remember { mutableStateOf(false) }

    Button(
        onClick = { clicado = !clicado}
    ){
        Text(
            text = (if (clicado) "Clicado!" else "Clique aqui"),
            fontSize = 18.sp
        )
    }
}

@Composable
fun TelaExemploTextField() {
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Formulario()
    }
}

@Composable
fun Formulario(){

    var nome by remember { mutableStateOf("") }
    var nomeDigitado by remember { mutableStateOf("Nenhum nome informado") }

    TextField(
        value = nome,
        onValueChange = { nome = it},
        label = {
            Text(text = "Digite seu nome")
        }
    )

    Spacer(modifier = Modifier.height(18.dp))

    Button(onClick = {
        if (nome.isNotBlank()) {
            nomeDigitado = nome
        }
    }) {
        Text(text = "Gravar nome")
    }

    Spacer(modifier = Modifier.height(18.dp))

    Text(text = nomeDigitado)
}