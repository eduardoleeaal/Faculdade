package com.eduardoleal.blocodenotas

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.eduardoleal.blocodenotas.ui.theme.BlocoDeNotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotasLayout()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotasLayout()
}


@Composable
fun NotasLayout(){

    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    val listaNotas = remember { mutableStateListOf<Nota>() }
    val contexto = LocalContext.current
    val foco = LocalFocusManager.current

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Bloco de Notas",
            fontSize = 25.sp)

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text(text = "Titulo" ) }
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            minLines = 5,
            maxLines = 10,
            label = { Text(text = "Descrição") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            enabled = titulo.isNotEmpty() && descricao.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val t = titulo.trim()
                val d = descricao.trim()

                if (t.isEmpty() || d.isEmpty()) {
                    Toast.makeText(contexto, "Preencha todos os dados", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                val nota = Nota(System.currentTimeMillis(), t, d)
                listaNotas.add(nota)

                titulo = ""
                descricao = ""
                foco.clearFocus()

            }) {
            Text(text = "Salvar")
        }

        Spacer(modifier = Modifier.height(50.dp))

        LazyColumn {

            items(listaNotas) {

                notaAtual ->
                Text(text = notaAtual.titulo,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable {
                            //todo enviar para outra activity
                            val intent = Intent(contexto, DetalhesActivity::class.java)
                            intent.putExtra("titulo", notaAtual.titulo)
                            intent.putExtra("descricao", notaAtual.descricao)
                            contexto.startActivity(intent)
                        })
            }
        }
    }
}