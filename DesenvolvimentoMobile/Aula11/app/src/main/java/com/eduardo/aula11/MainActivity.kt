package com.eduardo.aula11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.aula11.ui.theme.Aula11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navegador()
        }
    }
}
@Composable
fun Navegador() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "home") {

        composable("home") {
            TelaPrincipal(onIrParaSobre = { nav.navigate("sobre") })
        }

        composable("sobre") {
            TelaSobre(onVoltar = { nav.popBackStack() })
        }

    }
}
@Composable
fun TelaPrincipal(onIrParaSobre: () -> Unit){

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = "Tela Principal", fontSize = 25.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(50.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = onIrParaSobre) {
            Text(text = "Ir para 'Sobre'", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun TelaSobre(onVoltar: () -> Unit){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Sobre", fontSize = 25.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Data: 01/09/2025")
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Autor: Eduardo Leal")
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Aula de atividade: Aula 11")
        Spacer(modifier = Modifier.height(15.dp))
        
        Text(text = "Finalidade: Mostrar a navegação entre layouts composables", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(15.dp))

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = onVoltar) {
            Text(text = "Voltar para a 'Home'", textAlign = TextAlign.Center)
        }
    }
}