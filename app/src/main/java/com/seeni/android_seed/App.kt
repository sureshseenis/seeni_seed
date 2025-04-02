package com.seeni.android_seed

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

       //Notification channel for running service
       val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           NotificationChannel(
               "running_channel", "Running Notification", NotificationManager.IMPORTANCE_HIGH
           )
       } else {
           TODO("VERSION.SDK_INT < O")
       }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}