package com.seeni.android_seed.ui.view

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.seeni.android_seed.HybridCar
import com.seeni.android_seed.PetrolCar
import com.seeni.android_seed.di.AppSettingsSharedPreference
import com.seeni.android_seed.ui.theme.Seeni_seedTheme
import com.seeni.android_seed.ui.view.navigation.MainGraph
import com.seeni.android_seed.ui.view.utils.NetworkMonitor
import com.seeni.android_seed.ui.view.widget.NoInternetConnectionBanner
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val DARK_MODE = "dark_mode"
    }

    @Inject
    @AppSettingsSharedPreference
    lateinit var appSettings: SharedPreferences

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Inject
    lateinit var petrolCar: PetrolCar

    @Inject
    lateinit var hybridCar: HybridCar

    private fun isDarkModeEnabled() = appSettings.getBoolean(DARK_MODE, false)

    private fun enableDarkMode(enable: Boolean) =
        appSettings.edit().putBoolean(DARK_MODE, enable).commit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1)
        }

        setContent {
            val navController = rememberNavController()
            var darkMode by remember { mutableStateOf(isDarkModeEnabled()) }

            Seeni_seedTheme(darkMode) {
                Column {
                    val networkStatus by networkMonitor.networkState.collectAsState(null)

                    networkStatus?.let {
                        if (it.isOnline.not()) {
                            NoInternetConnectionBanner()
                        }
                    }
                    println("-------Hybrid car------")
                    println(hybridCar.start(true))
                    println(hybridCar.stop(true))
                    println(hybridCar.start(false))
                    println(hybridCar.stop(false))
                    println("-------Petrol car-------")
                    println(petrolCar.start())
                    println(petrolCar.stop())
                    MainGraph(
                        mainNavController = navController,
                        darkMode = darkMode,
                        onThemeUpdated = {
                            val updated = !darkMode
                            enableDarkMode(updated)
                            darkMode = updated
                        }
                    )
                }
            }
        }
    }
}