package com.anasstka.moviepedia.presentation.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.anasstka.moviepedia.presentation.movies.components.MovieItem
import com.anasstka.moviepedia.presentation.movies.components.SearchTextField

@ExperimentalCoilApi
@Composable
fun MoviesScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .padding(top = 16.dp)
        ) {
            SearchTextField(
                text = "",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White.copy(alpha = 0.4f))
                    .clip(RoundedCornerShape(10.dp)),
                onValueChange = {
//                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                onFocusChange = {
//                    viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
                },
//                isHintVisible = titleState.isHintVisible,
                isHintVisible = false,
                textStyle = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                modifier = Modifier
                    .then(Modifier.size(24.dp))
                    .align(Alignment.CenterVertically),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    tint = MaterialTheme.colors.onSurface,
                    contentDescription = "Add favorite"
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.movies) { movie ->
                MovieItem(
                    movie = movie,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {

                        },
                    onAddFavoriteClick = {

                    }
                )
            }
        }
    }
}