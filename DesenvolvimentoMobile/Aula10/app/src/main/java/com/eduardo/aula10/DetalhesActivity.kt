package com.eduardo.aula10

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardo.aula10.ui.theme.Aula10Theme

class DetalhesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Puxar os dados do contato
        val nome = intent.getStringExtra("nome") ?: "Não informado"
        val telefone = intent.getStringExtra("telefone") ?: "Não informado"
        val email = intent.getStringExtra("email") ?: "Não informado"


        setContent {
            LayoutDetalhes(nome, telefone, email, onBack = { finish() })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LayoutDetalhes("Leal", "41997321144", "eduardo.leeal@hotmail.com", {})
}

@Composable
fun LayoutDetalhes(nome: String, telefone: String, email: String, onBack: () -> Unit) {

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "DETALHES DO CONTATO", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Nome: $nome", fontSize = 20.sp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Telefone: $telefone", fontSize = 20.sp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "E-Mail: $email", fontSize = 20.sp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(50.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = onBack) {
            Text(text = "Voltar")
        }

    }
}
