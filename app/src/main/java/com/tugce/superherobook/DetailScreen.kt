package com.tugce.superherobook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap

import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset

@Composable
fun DetailScreen(superhero: Superhero) {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF141E30),
            Color(0xFF243B55)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = superhero.name,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center,

            )


            Image(
                bitmap = ImageBitmap.imageResource(id = superhero.image),
                contentDescription = superhero.name,
                modifier = Modifier
                    .size(width = 280.dp, height = 200.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            )


            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0x94FFBAF9), Color(0xFF5858A9))
                        ),
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Text(
                    text = superhero.universe,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
