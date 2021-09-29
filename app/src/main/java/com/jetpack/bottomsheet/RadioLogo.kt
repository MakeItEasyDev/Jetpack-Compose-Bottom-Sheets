package com.jetpack.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.jetpack.bottomsheet.ui.theme.Purple500

@Composable
fun TopSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadioLogo()

        Text(
            text = "FM Title / Make it Easy",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun RadioLogo() {
    val painter = rememberImagePainter(
        data = R.drawable.ic_baseline_radio_24,
        builder = {
            crossfade(true)
        },
        onExecute = { _, _-> true }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(250.dp)
            .shadow(30.dp, CircleShape)
            .background(
                color = Color.LightGray,
                shape = CircleShape
            )
            .border(10.dp, Purple500, CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = "Radio",
            modifier = Modifier
                .size(150.dp)
                .padding(15.dp)
        )

        when (painter.state) {
            is ImagePainter.State.Error -> {
                Icon(
                    imageVector = Icons.Filled.Radio,
                    contentDescription = "Radio",
                    tint = Purple500,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}

@Composable
fun PlayerControls(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {

            },
            modifier = Modifier.padding(15.dp, 8.dp, 8.dp, 8.dp)
        ) {
            Image(
                imageVector = Icons.Filled.VolumeUp,
                contentDescription = "Volume"
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {  },
                modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 15.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.SkipPrevious,
                    contentDescription = "Previous"
                )
            }

            PlayPauseButton(onClick = {})

            IconButton(
                onClick = {  },
                modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 15.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.SkipNext,
                    contentDescription = "Next"
                )
            }
        }

        IconButton(
            onClick = {  },
            modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 15.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favourite"
            )
        }
    }
}

@Composable
fun PlayPauseButton(
    onClick: () -> Unit
) {
    CircleIconButtonLarge(
        background = Color.LightGray,
        imageVector = Icons.Filled.PlayArrow,
        onClick = onClick
    )
}

@Composable
fun CircleIconButtonLarge(
    background: Color,
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape)
            .background(background, CircleShape)
            .clickable(
                indication = rememberRipple(bounded = true),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick() }
            )
    ) {
        Icon(imageVector = imageVector, contentDescription = "")
    }
}














