package com.eduardoleal.aula07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardoleal.aula07.ui.theme.Aula07Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutJogo()
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewLayout() {
    LayoutJogo()
}

@Composable
fun LayoutJogo() {
    Column (
        modifier = Modifier.fillMaxSize().padding(15.dp)
    ){
        Text(
            text = "Pedra, Papel, Tesoura!",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Escolha sua jogada: ",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        BotoesJogo()
    }
}

@Composable
fun BotoesJogo() {

}