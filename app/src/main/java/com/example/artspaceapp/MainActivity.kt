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
                    artworkImage = R.drawable.young_darren_in_cage,
                    artworkName = R.string.young_darren,
                    artworkArtistAndYear = R.string.artist_name_and_year,
                    artworkImageContentDescription = null,
                    onPreviousClick = {currentArtwork = 4},
                    onNextClick = {currentArtwork = 2},
                )
            }
            2 -> {

                ImageAndText(
                    artworkImage = R.drawable.darren_chewing_calculus_notes,
                    artworkName = R.string.darren_chewing_notes,
                    artworkArtistAndYear = R.string.artist_name_and_year,
                    artworkImageContentDescription = null,
                    onPreviousClick = {currentArtwork = 1},
                    onNextClick = {currentArtwork = 3},
                )
            }
            3 -> {
                ImageAndText(
                    artworkImage = R.drawable.darren_on_glasses,
                    artworkName = R.string.darren_on_glasses,
                    artworkArtistAndYear = R.string.artist_name_and_year,
                    artworkImageContentDescription = null,
                    onPreviousClick = {currentArtwork = 2},
                    onNextClick = {currentArtwork = 4},
                )
            }
            4 -> {
                ImageAndText(
                    artworkImage = R.drawable.darren_on_knee,
                    artworkName = R.string.darren_on_knee,
                    artworkArtistAndYear = R.string.artist_name_and_year,
                    artworkImageContentDescription = null,
                    onPreviousClick = {currentArtwork = 3},
                    onNextClick = {currentArtwork = 1},
                )
            }
        }


}

@Composable
fun ImageAndText(
    artworkImage: Int,
    artworkImageContentDescription: String?,
    artworkName: Int,
    artworkArtistAndYear: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit
    ) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        ArtworkWall(image = artworkImage, contentDescription = artworkImageContentDescription)
        Spacer(modifier = Modifier.height(20.dp) )
        ArtworkDescription(artworkName = artworkName, artistAndYear = artworkArtistAndYear)
        Spacer(modifier = Modifier.height(20.dp))
        PreviousAndNextButton(onNextClick = onNextClick, onPreviousClick = onPreviousClick)
    }

}

@Composable
fun ArtworkWall(image: Int, contentDescription: String?) {
    Surface(modifier = Modifier.fillMaxWidth(), color = Color.White, elevation = 10.dp, border = BorderStroke(2.dp, Color.LightGray)
        ) {
        Image(modifier = Modifier.padding(30.dp),
            painter = painterResource(id = image),
            contentDescription = contentDescription)
    }

}
@Composable
fun ArtworkDescription(artworkName: Int, artistAndYear: Int) {
    Surface(elevation = 5.dp, color = Color.White) {
        Column() {
            Text(text = stringResource(id = artworkName))
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