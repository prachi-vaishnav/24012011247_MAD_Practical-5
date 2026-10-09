package com.example.a24012011247_mad_practical_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun checkboxDemo(modifier: Modifier = Modifier) {

    var redstate by remember { mutableStateOf(true) }
    var greenstate by remember { mutableStateOf(true) }
    var bluestate by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "CheckboxDemo")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = redstate,
                onCheckedChange = {
                    redstate = it
                }
            )
            Text(text = "Red")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = greenstate,
                onCheckedChange = {
                    greenstate = it
                }
            )
            Text(text = "Green")
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = bluestate,
                onCheckedChange = {
                    bluestate = it
                }
            )
            Text(text = "Blue")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 10.dp)
                .background(
                    if (redstate) Color.Red else Color.Transparent
                )
                .padding(13.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        if (greenstate) Color.Green else Color.Transparent
                    )
                    .padding(13.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (bluestate) Color.Blue else Color.Transparent
                        )
                )
            }
        }
    }
}
