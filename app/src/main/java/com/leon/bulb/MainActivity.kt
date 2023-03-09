package com.leon.bulb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leon.bulb.R.drawable.off
import com.leon.bulb.ui.theme.BulbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BulbTheme {
                BulbApp()
            }
        }
    }
}

@Preview
@Composable
fun BulbApp() {
    BulbWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun BulbWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( true) }

    val imageResource = if(result == true) {
     R.drawable.off}
        else { R.drawable.on
    }

    val stringR = if(result == true) {
        R.string.switch1}
        else {R.string.switch2
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { if(result == false ){
            result = true
        }else{
            result = false
        } }) {
            Text(text = stringResource(stringR), fontSize = 24.sp)
        }
    }
}

