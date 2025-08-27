package com.tugce.superherobook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import kotlin.math.min

@Composable
fun SuperheroList(superheros: List<Superhero>, navController: NavController) {
    val listState = rememberLazyListState()
    val firstVisibleItemScrollOffset = listState.firstVisibleItemScrollOffset
    val scrollFactor = min(firstVisibleItemScrollOffset / 600f, 1f)

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(superheros) {
            SuperheroRow(
                superhero = it,
                navController = navController,
                scrollFactor = scrollFactor
            )
        }
    }
}

@Composable
fun SuperheroRow(superhero: Superhero, navController: NavController, scrollFactor: Float) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFB3E5FC).copy(alpha = 1f - scrollFactor),
            Color(0xFF0288D1).copy(alpha = 0.9f - scrollFactor / 2)
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("details_screen/${Gson().toJson(superhero)}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradientBrush) // Gradient buraya
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = superhero.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = superhero.universe,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}
