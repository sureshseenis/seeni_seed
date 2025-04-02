package com.seeni.android_seed

import com.seeni.android_seed.di.Battery
import com.seeni.android_seed.di.Diesel
import com.seeni.android_seed.di.Petrol
import javax.inject.Inject

interface Engine {
    fun start(): String
    fun stop(): String
}

class PetrolEngine @Inject constructor() : Engine {
    override fun start() = "Start Petrol Engine"

    override fun stop() = "Stop Petrol Engine"
}

class DieselEngine @Inject constructor() : Engine {
    override fun start() = "Start Diesel Engine"

    override fun stop() = "Stop Diesel Engine"
}

class BatteryEngine @Inject constructor() : Engine {
    override fun start() = "Start Battery Engine"
    override fun stop() = "Stop Battery Engine"
}

class DieselCar @Inject constructor(@Diesel private val engine: Engine) {
    fun start() = engine.start()
    fun stop() = engine.stop()
}

class PetrolCar @Inject constructor(@Petrol private val engine: Engine) {
    fun start() = engine.start()
    fun stop() = engine.stop()
}

class HybridCar @Inject constructor(
    @Petrol private val petrolEngine: Engine,
    @Battery private val battery: Engine
) {
    fun start(isUseBattery: Boolean) = if (isUseBattery) battery.start() else petrolEngine.start()

    fun stop(isUseBattery: Boolean) = if (isUseBattery) battery.stop() else petrolEngine.stop()
}

