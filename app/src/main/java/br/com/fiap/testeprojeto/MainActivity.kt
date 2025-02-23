package br.com.fiap.testeprojeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.testeprojeto.ui.theme.TesteProjetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TesteProjetoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente(modifier: Modifier = Modifier) {

    var idade = remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .background(color = Color(0xFFFFFFFF))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Qual a sua idade?",
            fontSize = 24.sp,
            color = Color(0xFFAD1F4E),
            fontWeight = FontWeight.Bold
            )

            Text(
                text = "Aperte os botões para informar a sua idade.",
            fontSize = 12.sp
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text(
                text = "${idade.value}",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    onClick = {
                        if (idade.value>=1){
                            idade.value--
                        } else{
                            idade.value = 0
                        }

                    },
                    modifier = Modifier.size(84.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
                ) {
                    Text(text = "-", fontSize = 40.sp)
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        if (idade.value<=130){
                            idade.value++
                        } else{
                            idade.value = 0
                        }

                    },
                    modifier = Modifier.size(84.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
                ) {
                    Text(text = "+", fontSize = 40.sp)
                }

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = if (idade.value >= 18) {
                    "Maior de Idade"
                } else {
                    "Menor de Idade"
                },
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    MeuComponente()

}

@Composable
fun CounterScreen() {

}