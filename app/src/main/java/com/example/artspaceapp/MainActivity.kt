package com.example.artspaceapp

import android.graphics.drawable.RotateDrawable
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
import androidx.compose.runtime.*
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
                    ArtSpaceAlbum()

                }
            }
        }
    }
}
@Composable
fun ArtSpaceAlbum() {
    var currentArtwork by remember { mutableStateOf(1) }


    when (currentArtwork) {
            1 -> {

                ImageAndText(
                    textLabelResourceId = R.string.lemon_select,
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemon_tree_content_description,
                    onImageClick = {
                        // Update to next step
                        currentStep = 2
                        // Each time a lemon is picked from the tree, get a new random number
                        // between 2 and 4 (inclusive) for the number of times the lemon needs
                        // to be squeezed to turn into lemonade
                        squeezeCount = (2..4).random()
                    }
                )
            }
            2 -> {
                // Display lemon image and ask user to squeeze the lemon
                ImageAndText(
                    textLabelResourceId = R.string.lemon_squeeze,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemon_content_description,
                    onImageClick = {
                        // Decrease the squeeze count by 1 for each click the user performs
                        squeezeCount--
                        // When we're done squeezing the lemon, move to the next step
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
            }
            3 -> {
                // Display glass of lemonade image and ask user to drink the lemonade
                ImageAndText(
                    textLabelResourceId = R.string.lemon_drink,
                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.lemonade_content_description,
                    onImageClick = {
                        // Update to next step
                        currentStep = 4
                    }
                )
            }
            4 -> {
                // Display empty glass image and ask user to start again
                ImageAndText(
                    textLabelResourceId = R.string.lemon_empty_glass,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.empty_glass_content_description,
                    onImageClick = {
                        // Back to starting step
                        currentStep = 1
                    }
                )
            }
        }


}

@Composable
fun ImageAndText(
    artworkImage: Int,
    artworkImageDescription: Int,
    artworkName: Int,
    artworkArtistAndYear: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit
    ) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        ArtworkWall(image = artworkImage, contentDescription = artworkImageDescription)
        Spacer(modifier = Modifier.height(20.dp) )
        ArtworkDescription(artwork = artworkName, artistAndYear = artworkArtistAndYear)
        Spacer(modifier = Modifier.height(20.dp))
        PreviousAndNextButton(onNextClick = onNextClick, onPreviousClick = onPreviousClick)
    }

}

@Composable
fun ArtworkWall(image: Int, contentDescription: Int) {
    Surface(modifier = Modifier.fillMaxWidth(), color = Color.White, elevation = 10.dp, border = BorderStroke(2.dp, Color.LightGray)
        ) {
        Image(modifier = Modifier.padding(30.dp),
            painter = painterResource(id = image),
            contentDescription = stringResource(id = contentDescription))
    }

}
@Composable
fun ArtworkDescription(artwork: Int, artistAndYear: Int) {
    Surface(elevation = 5.dp, color = Color.White) {
        Column() {
            Text(text = stringResource(id = artwork))
            Text(text = stringResource(id = artistAndYear))
        }
    }

}
@Composable 
fun PreviousAndNextButton(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier.padding(start = 10.dp),
            contentPadding = PaddingValues(start = 40.dp, end = 40.dp),
            onClick = onPreviousClick
        ) {
            Text(text = stringResource(id = R.string.previous_button) )

        }
        Button(modifier = Modifier.padding(end = 10.dp),
            contentPadding = PaddingValues(start = 50.dp, end = 50.dp),
            onClick = onNextClick
        ) {
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