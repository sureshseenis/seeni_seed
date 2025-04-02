package com.seeni.android_seed.di.module

import android.content.Context
import android.content.SharedPreferences
import com.seeni.android_seed.di.AppSettingsSharedPreference
import com.seeni.android_seed.ui.view.utils.NetworkMonitor
import com.seeni.android_seed.ui.view.utils.NetworkMonitorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @AppSettingsSharedPreference
    fun provideAppSettingsSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideNetworkMonitor(
        @ApplicationContext context: Context
    ): NetworkMonitor = NetworkMonitorImpl(context)
}