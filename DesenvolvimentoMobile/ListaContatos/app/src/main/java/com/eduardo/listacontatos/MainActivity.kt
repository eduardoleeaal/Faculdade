package com.eduardo.listacontatos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.listacontatos.ui.theme.ListaContatosTheme

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
fun Navegador(){
    val navController = rememberNavController()
    val listaContatos = remember { mutableStateListOf<Contato>() }
    var idContatoSelecionado by remember { mutableStateOf<Long?>(null) }
    NavHost(navController, startDestination = "contato"){
        composable("contato"){
           TelaContato(
               listaDeContatos = listaContatos,
               onAdicionar = { nome, telefone, email ->
                   val contato = Contato(
                       id = System.currentTimeMillis(),
                       nome = nome,
                       fone = telefone,
                       email = email
                   )

                   listaContatos.add(contato)
               },
               onExibirDetalhes = {
                   idAtual ->
                   idContatoSelecionado = idAtual
                   navController.navigate("detalhes")
               }
           )
        }
        composable("detalhes") {
            val contato = listaContatos.firstOrNull() { it.id == idContatoSelecionado }
            TelaDetalhes(contato = contato, onVoltar = { navController.popBackStack() })
        }
    }
}

@Composable
fun TelaContato(
    listaDeContatos: List<Contato>,
    onAdicionar: (String, String, String) -> Unit,
    onExibirDetalhes: (Long) -> Unit
    ){

    var nome by remember { mutableStateOf("") }
    var fone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val contexto = LocalContext.current
    val focusManager = LocalFocusManager.current

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Lista de contatos", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(value = fone, onValueChange = { fone = it }, label = { Text(text = "Telefone") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text(text = "E-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            enabled = nome.isNotEmpty() && fone.isNotEmpty() && email.isNotEmpty(),
            onClick = {
                val n = nome.trim()
                val f = fone.trim()
                val e = email.trim()

                if (n.isEmpty() || f.isEmpty() || e.isEmpty()) {
                    Toast.makeText(contexto, "Preencha todos os dados", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                onAdicionar(n, f, e)

                nome = ""
                fone = ""
                email = ""
                focusManager.clearFocus()

            }
        ) {
            Text(text = "Salvar", textAlign = TextAlign.Center, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(5.dp)) {

            items(listaDeContatos){

                contatoAtual ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable{ onExibirDetalhes(contatoAtual.id) }
                        .padding(10.dp)
                ) {
                    Text(text = contatoAtual.nome, fontSize = 18.sp)
                }
            }
        }

    }
}

@Composable
fun TelaDetalhes(
    contato : Contato?,
    onVoltar: () -> Unit
    ) {

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally ) {

        Text(text = "Detalhes do Contato", fontSize = 25.sp, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(15.dp))

        if (contato == null) {
            Text(text = "Contato não localizado", fontSize = 20.sp, textAlign = TextAlign.Center)
        } else {
            Text(
                text = "Nome: ${contato.nome}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(
                text = "Telefone: ${contato.fone}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(
                text = "E-mail: ${contato.email}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
        }


        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onVoltar
        ) {

            Text(
                text = "Voltar para Lista de contatos",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }

}