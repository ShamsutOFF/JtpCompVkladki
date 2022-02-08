package com.example.jtpcompvkladki

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jtpcompvkladki.model.Photo

@Composable
fun PhotoItem(photo: Photo) {
    Card( modifier = Modifier
        .padding(4.dp).fillMaxSize(),
        backgroundColor = Color.LightGray) {
        Image(painter = rememberImagePainter(photo.downloadUrl), contentDescription = photo.author,
            modifier = Modifier.size(396.dp))
        Text(
            text = photo.author,
            maxLines = 2,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis
        )
    }
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}