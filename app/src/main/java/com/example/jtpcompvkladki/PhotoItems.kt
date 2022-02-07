package com.example.jtpcompvkladki

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jtpcompvkladki.model.Photo
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PhotoItem(photo: Photo) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieTitle(
            photo.author,
            modifier = Modifier.weight(1f)
        )
//        CoilImage(data = ) {
//
//        }
//        MovieImage(
//            photo.downloadUrl,
//            modifier = Modifier.padding(start = 16.dp).preferredSize(90.dp)
//        )
    }
}

//@Composable
//fun MovieImage(
//    imageUrl: String,
//    modifier: Modifier = Modifier
//) {
//    CoilImage(
//        data = imageUrl,
//        modifier = modifier,
//        fadeIn = true,
//        contentScale = ContentScale.Crop,
//        loading = {
//            Image(vectorResource(id = R.drawable.ic_photo), alpha = 0.45f)
//        },
//        error = {
//            Image(vectorResource(id = R.drawable.ic_broken_image), alpha = 0.45f)
//        }
//    )
//}

@Composable
fun MovieTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        style = MaterialTheme.typography.h6,
        overflow = TextOverflow.Ellipsis
    )
}