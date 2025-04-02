package com.seeni.android_seed

import com.seeni.android_seed.di.Battery
import com.seeni.android_seed.di.Diesel
import com.seeni.android_seed.di.Petrol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Diesel
    @Provides
    fun providesDieselEngine(): Engine = DieselEngine()

    @Petrol
    @Provides
    fun providesPetrolEngine(): Engine = PetrolEngine()

    @Battery
    @Provides
    fun providesBatterEngine(): Engine = BatteryEngine()
}