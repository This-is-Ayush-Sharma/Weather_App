package com.ayush.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class MainActivity2 : AppCompatActivity() {
    lateinit var date:TextView
    lateinit var time:TextView
    lateinit var temp:TextView
    lateinit var humi:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // find the view of the activities.
        date = findViewById(R.id.FetchDate)
        time = findViewById(R.id.fetchTime)
        temp = findViewById(R.id.fetchTemprature)
        humi = findViewById(R.id.fetchHumidity)
    val http = provideOkHttpClient()
        val gson = Gson()
        val scarletInstance = Scarlet.Builder()
            .webSocketFactory(http.newWebSocketFactory("http://52.158.43.115:5000"))
            .addMessageAdapterFactory(CustomGsonMessageAdapter.Factory(gson))
            .addStreamAdapterFactory(FlowStreamAdapter.Factory)
            .lifecycle(AndroidLifecycle.ofApplicationForeground(application))
            .build()
            .create(WeatherWs::class.java)




        scarletInstance


    }
    fun provideOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    }
}