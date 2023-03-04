package com.ayush.weatherapp

import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import kotlinx.coroutines.flow.Flow

interface WeatherWs {
    @Receive
    fun observeWeatherEvent(): Flow<AppData>
}