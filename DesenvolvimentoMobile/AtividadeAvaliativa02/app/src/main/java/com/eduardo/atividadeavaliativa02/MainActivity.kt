package com.eduardo.atividadeavaliativa02

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.atividadeavaliativa02.ui.theme.AtividadeAvaliativa02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigator()
        }
    }
}

@Composable
fun Navigator() {
    val navController = rememberNavController()
    val listaDeJogos = remember { mutableStateListOf<Jogo>() }
    var idJogoAtual by remember { mutableStateOf<Long?>(null) }

    NavHost(navController, startDestination = "initial") {

        composable("initial") {
            InitialScreen(
                listaDeJogos = listaDeJogos,
                onAdd = { tit, gen, anoL ->
                    val jogo = Jogo(
                        id = System.currentTimeMillis(),
                        titulo = tit,
                        genero = gen,
                        anoLancamento = anoL
                    )

                    listaDeJogos.add(jogo)

                },
                onShowDetails = { idAtual ->
                    idJogoAtual = idAtual
                    navController.navigate("details")
                }
            )
        }
        composable("details") {
            val jogoSelecionado = listaDeJogos.firstOrNull() { it.id == idJogoAtual }
            DetailsScreen(
                jogo = jogoSelecionado,
                onBack = { navController.popBackStack() }
            )
        }
    }
}


@Composable
fun InitialScreen(
    listaDeJogos: List<Jogo>,
    onAdd: (String, String, String) -> Unit,
    onShowDetails: (Long) -> Unit
    ) {

    var titulo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var anoLancamento by remember { mutableStateOf("") }
    val contexto = LocalContext.current
    val foco = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Cadastro de Jogos", fontSize = 30.sp)

        Spacer(Modifier.height(30.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text(text = "Título") }
        )
        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text(text = "Genêro") }
        )
        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            value = anoLancamento,
            onValueChange = { anoLancamento = it },
            label = { Text(text = "Ano de Lançamento") }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val t = titulo.trim()
                val g = genero.trim()
                val a = anoLancamento.trim()

                if (t.isEmpty() || g.isEmpty() || a.isEmpty()){
                    Toast.makeText(contexto, "Preencha todos os Campos", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                onAdd(t, g, a)

                titulo = ""
                genero = ""
                anoLancamento = ""
                foco.clearFocus()

            }) {
            Text(text = "Salvar", fontSize = 15.sp)
        }

        Spacer(Modifier.height(15.dp))

        LazyColumn {

            items(listaDeJogos) {
                jogoAtual ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable{ onShowDetails(jogoAtual.id) }
                        .padding(vertical = 5.dp)
                )
                {
                    Text(text = jogoAtual.titulo)
                }
            }
        }
    }
}

@Composable
fun DetailsScreen(
    jogo: Jogo?,
    onBack: () -> Unit
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (jogo == null){
            Text(text = "Jogo não encontrado")
        }
        else {
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Detalhes do jogo ${jogo.titulo}",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Gênero: ${jogo.genero}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Ano de lançamento: ${jogo.anoLancamento}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(Modifier.height(40.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBack
            ) {
                Text(
                    text = "Voltar para a home",
                    fontSize = 15.sp
                )
            }
        }
    }
}