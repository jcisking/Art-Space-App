package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}
@Composable
fun ImageAndText() {
    Column {
        Image(painter = , contentDescription = )
        Spacer(modifier = )
        ArtworkDescription()
        Spacer(modifier = )
        PreviousAndNextButton()


    }
}
@Composable
fun ArtworkDescription() {
    Column() {
        Text(text = )
        Text(text = )
        
    }
}
@Composable 
fun PreviousAndNextButton() {
    Row() {
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.previous_button) )
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