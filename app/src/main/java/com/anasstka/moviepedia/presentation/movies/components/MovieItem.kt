package com.anasstka.moviepedia.presentation.movies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.anasstka.moviepedia.common.Constants
import com.anasstka.moviepedia.domain.model.Movie
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalCoilApi
@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    onAddFavoriteClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {

        Card(
            modifier = modifier,
            shape = RoundedCornerShape(cornerRadius),
            elevation = 5.dp
        ) {
            Box(
//                modifier = Modifier.padding(15.dp)
            ) {
                GlideImage(
                    imageModel = Constants.BASE_IMAGE_URL + movie.poster,
                    contentScale = ContentScale.FillWidth,
//                    circularReveal = CircularReveal(duration = 250),
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 400f
                            )
                        )
                )
                Row(
                    modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().padding(8.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = movie.originalTitle,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                        maxLines = 1
                    )
                    IconButton(
                        modifier = Modifier
                            .then(Modifier.size(24.dp))
                            .align(Alignment.CenterVertically),
                        onClick = onAddFavoriteClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.StarBorder,
                            tint = MaterialTheme.colors.onSurface,
                            contentDescription = "Add favorite"
                        )
                    }
                }
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(12.dp),
//                    contentAlignment = Alignment.BottomStart
//                ) {
//                    Text(
//                        text = movie.originalTitle,
//                        style = TextStyle(color = Color.White, fontSize = 16.sp)
//                    )
//                }
            }
        }

//        GlideImage(
//            imageModel = Constants.BASE_IMAGE_URL + movie.poster,
//            contentScale = ContentScale.FillWidth,
//            circularReveal = CircularReveal(duration = 250),
//        )
//
//        Spacer(modifier = Modifier.height(14.dp))
//        Row(
//            modifier = Modifier.padding(horizontal = 25.dp)
//        ) {
//            Text(
//                modifier = Modifier.weight(1f),
//                text = movie.originalTitle,
//                style = MaterialTheme.typography.h6,
//                color = MaterialTheme.colors.onSurface,
//                maxLines = 1
//            )
//            IconButton(
//                modifier = Modifier
//                    .then(Modifier.size(24.dp))
//                    .align(Alignment.CenterVertically),
//                onClick = onAddFavoriteClick
//            ) {
//                Icon(
//                    imageVector = Icons.Default.StarBorder,
//                    tint = MaterialTheme.colors.onSurface,
//                    contentDescription = "Add favorite"
//                )
//            }
//        }
    }
}