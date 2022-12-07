package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ImageAndText()

                }
            }
        }
    }
}
@Composable
fun ImageAndText() {
    Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.close_up_beef_hamberger_wooden_plate_174264764), contentDescription = null)
        Spacer(modifier = Modifier.height(20.dp) )
        ArtworkDescription()
        Spacer(modifier = Modifier.height(20.dp))
        PreviousAndNextButton()


    }
}
@Composable
fun ArtworkDescription() {
    Column() {
        Text(text = "ksdng")
        Text(text = "kasjgn")
        
    }
}
@Composable 
fun PreviousAndNextButton() {
    Row() {
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.previous_button) )

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.next_button))

        }
        
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {

    }
}