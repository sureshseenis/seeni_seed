@file:Suppress("MatchingDeclarationName", "Filename")

package com.seeni.android_seed.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppSettingsSharedPreference

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Petrol

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Diesel

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Battery