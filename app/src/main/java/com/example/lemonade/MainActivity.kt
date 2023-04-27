package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme


var imaxes = arrayOf<Painter>()
var descricions = arrayOf<String>()
var etiquetas =  arrayOf<String>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun InicializaTablas(){
    val imaxesL = arrayOf<Painter>(
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_tree)
    )
    imaxes = imaxesL

    val descricionsL = arrayOf<String>(
        stringResource(R.string.descricion_1),
        stringResource(R.string.descricion_2),
        stringResource(R.string.descricion_3),
        stringResource(R.string.descricion_4)
    )
    descricions = descricionsL

    val etiquetasL = arrayOf<String>(
        stringResource(R.string.etiqueta_1),
        stringResource(R.string.etiqueta_2),
        stringResource(R.string.etiqueta_3),
        stringResource(R.string.etiqueta_4)
    )
    etiquetas = etiquetasL
}

@Composable
fun LemonApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        InicializaTablas()
        PintaPantalla(indice = 0)
    }
}

@Composable
fun PintaPantalla(indice: Int, modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imaxes[indice],
            contentDescription = descricions[indice]
        )
        Text(
            text = etiquetas[indice]
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}