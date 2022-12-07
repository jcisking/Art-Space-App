package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun ArtSpaceApp() {

}

@Composable
fun ImageAndText() {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        ArtworkWall()
        Spacer(modifier = Modifier.height(20.dp) )
        ArtworkDescription()
        Spacer(modifier = Modifier.height(20.dp))
        PreviousAndNextButton()
    }

}

@Composable
fun ArtworkWall() {
    Surface(modifier = Modifier.fillMaxWidth(), color = Color.White, elevation = 10.dp, border = BorderStroke(5.dp, Color.LightGray)
        ) {
        Image(modifier = Modifier.padding(30.dp), painter = painterResource(id = R.drawable.close_up_beef_hamberger_wooden_plate_174264764), contentDescription = null)
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
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
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