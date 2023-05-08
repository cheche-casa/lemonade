package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    imaxes = arrayOf<Painter>(
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_tree)
    )

    descricions = arrayOf<String>(
        stringResource(R.string.descricion_1),
        stringResource(R.string.descricion_2),
        stringResource(R.string.descricion_3),
        stringResource(R.string.descricion_4)
    )

    etiquetas = arrayOf<String>(
        stringResource(R.string.etiqueta_1),
        stringResource(R.string.etiqueta_2),
        stringResource(R.string.etiqueta_3),
        stringResource(R.string.etiqueta_4)
    )
}

@Composable
fun LemonApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        InicializaTablas()
        PintaPantalla()
    }
}

@Composable
fun PintaPantalla(modifier: Modifier = Modifier){
    var indice by remember { mutableStateOf(0) }
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.clickable ( enabled = true, onClick = {indice++} ),
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