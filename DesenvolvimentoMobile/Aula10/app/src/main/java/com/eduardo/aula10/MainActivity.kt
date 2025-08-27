package com.eduardo.aula10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutMain()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutMain()
}

@Composable
fun LayoutMain() {

    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val listaContatos = remember { mutableStateListOf<Contato>() }
    val contexto = LocalContext.current
    val focus = LocalFocusManager.current

    Column (modifier = Modifier
        .padding(10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Lista de Contatos", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = nome,
            onValueChange = { nome = it },
            label = { Text(text = "Nome") })

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = telefone,
            onValueChange = {telefone = it },
            label = { Text(text = "Telefone") })

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "E-mail") })

        Spacer(modifier = Modifier.height(15.dp))

        Button(enabled = nome.isNotEmpty() && telefone.isNotEmpty() && email.isNotEmpty(), onClick = {

            val n = nome.trim()
            val t = telefone.trim()
            val e = email.trim()

            if (n.isEmpty() || t.isEmpty() || e.isEmpty()) {
                Toast.makeText(contexto,
                    "Preencha todos os campos",
                    Toast.LENGTH_SHORT).show()
                return@Button
            }

            val contato = Contato(System.currentTimeMillis(), n, t, e)

            listaContatos.add(contato)
            nome = ""
            telefone = ""
            email = ""
            focus.clearFocus()

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Salvar")
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn {
            items(listaContatos) {
                contatoAtual ->
                Text(text = contatoAtual.nome,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable{
                            val intent = Intent(contexto, DetalhesActivity::class.java)
                            intent.putExtra("nome", contatoAtual.nome)
                            intent.putExtra("telefone", contatoAtual.telefone)
                            intent.putExtra("email", contatoAtual.email)
                            contexto.startActivity(intent)
                        }
                )
            }
        }

    }
}