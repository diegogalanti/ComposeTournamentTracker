package com.gallardo.composetournamenttracker.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.gallardo.composetournamenttracker.BuildConfig
import com.gallardo.composetournamenttracker.R
import com.gallardo.composetournamenttracker.domain.model.Group

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupCard(group: Group, modifier: Modifier = Modifier, expanded : Boolean, onExpand : (String) -> Unit) {
    Log.e("OXI2","OXI2")
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            group.teams.forEach() {
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = CenterHorizontally
                ) {
                    Box(
                        modifier = modifier
                            .height(70.dp)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(BuildConfig.BACKEND_FLAG_URL + it.flag)
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = "Team flag for ${it.name}",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds,
                            placeholder = painterResource(id = R.drawable.loading_img),
                            error = painterResource(id = R.drawable.ic_broken_image),
                        )
                    }
                    Text(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        text = "0",
                        style = MaterialTheme.typography.bodyLarge,

                        )
                }
            }


        }
        Divider(thickness = 1.dp, color = Color.Black, modifier = modifier.padding(horizontal = 8.dp))
        Row(modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                text = stringResource(R.string.group_name, group.name),
                style = MaterialTheme.typography.headlineSmall
            )

            Button(onClick = { onExpand(group.key) }) {
                Text(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = stringResource(R.string.expand_string, group.name)
                )
                Icon(painter = painterResource(id = R.drawable.ic_expand_more_24), contentDescription = "Expand Card")
            }
        }
        if (expanded) {
            Divider(thickness = 1.dp, color = Color.Black, modifier = modifier.padding(horizontal = 8.dp))
            Row(modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = stringResource(R.string.group_name, group.name),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }


}

