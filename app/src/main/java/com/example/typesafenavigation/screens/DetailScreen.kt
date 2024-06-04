package com.example.typesafenavigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.typesafenavigation.R
import com.example.typesafenavigation.navigation.Home

@Composable
fun DetailScreen(
    navController: NavHostController,
    age: Int,
    name: String
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        // If you want to pass any data to the previous screen :->
                        navController.navigate(Home) {
                            popUpTo(Home) {
                                inclusive = true
                            }
                        }
                    }
            )

            Text(
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                text = "Detail Screen"
            )

            // Arguments :->
            Text(
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                text = "Name : $name"
            )
            Text(
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                text = "Age : $age"
            )
        }
    }

}