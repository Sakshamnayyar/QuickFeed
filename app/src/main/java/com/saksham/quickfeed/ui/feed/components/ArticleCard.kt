package com.saksham.quickfeed.ui.feed.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.saksham.quickfeed.domain.model.Post

@Composable
fun ArticleCard(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(post.title,style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.padding(6.dp))

            Text(post.description ?: "", maxLines = 3, overflow = TextOverflow.Ellipsis)

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "${post.sourceName} • ${post.publishedAt.take(10)}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray)


        }
    }
}
