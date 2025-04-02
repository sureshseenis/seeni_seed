package com.seeni.android_seed.ui.view.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.seeni.android_seed.service.RunningService
import com.seeni.android_seed.ui.theme.colors

@Composable
fun HomeScreen() {
    val localContext = LocalContext.current
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedButton(onClick = {
                Intent(localContext.applicationContext, RunningService::class.java).also {
                    it.action = RunningService.Actions.START.toString()
                    localContext.startService(it)
                }
            }) {
                Text("Start Service", color = colors.onPrimary)
            }

            OutlinedButton(onClick = {
                Intent(localContext.applicationContext, RunningService::class.java).also {
                    it.action = RunningService.Actions.STOP.toString()
                    localContext.startService(it)
                }
            }) {
                Text("End Service", color = colors.onPrimary)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}