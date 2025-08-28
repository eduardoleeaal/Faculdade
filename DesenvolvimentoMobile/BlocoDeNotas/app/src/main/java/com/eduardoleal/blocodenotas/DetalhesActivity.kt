package com.eduardoleal.blocodenotas

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
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardoleal.blocodenotas.ui.theme.BlocoDeNotasTheme

class DetalhesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val titulo = intent.getStringExtra("titulo") ?: "Não Informado"
        val descricao = intent.getStringExtra("descricao") ?: "Não informado"

        setContent {
            DetalheLayout(titulo = titulo, descricao = descricao, onBack ={ finish() })
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    DetalheLayout("Teste", LoremIpsum(90).values.first(), onBack = {})
}

@Composable
fun DetalheLayout(titulo: String, descricao: String, onBack: () -> Unit){

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = titulo, fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(modifier = Modifier.fillMaxWidth(),
            text = "Descrição: \n\n$descricao", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Voltar")
        }
    }

}