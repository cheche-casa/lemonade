package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    imaxes = arrayOf(
        painterResource(R.drawable.lemon_tree),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart)
    )

    descricions = arrayOf(
        stringResource(R.string.descricion_1),
        stringResource(R.string.descricion_2),
        stringResource(R.string.descricion_3),
        stringResource(R.string.descricion_4)
    )

    etiquetas = arrayOf(
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
    var aleatorio by remember {mutableStateOf((1..3).random())}
    var veces = 0

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier
            .clickable(enabled = true, onClick = {
                    if (indice == 1 && veces != aleatorio) {
                        veces++
                    }
                    else {
                        if (indice == 1) {
                            aleatorio = (1..3).random()
                        }
                        indice++
                        if (indice == 4) {
                            indice = 0
                        }
                    }
                }
            )
            .border(1.dp, Color.Blue, shape = CutCornerShape(5.dp))
            .wrapContentSize(),
            painter = imaxes[indice],
            contentDescription = descricions[indice]
        )
        Text(modifier = modifier.padding(vertical = 18.dp, horizontal = 10.dp),
            text = etiquetas[indice],
            fontSize = 18.sp,
            textAlign = Center
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