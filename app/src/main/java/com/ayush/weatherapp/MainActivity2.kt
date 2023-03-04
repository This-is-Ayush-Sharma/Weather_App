package com.ayush.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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


    }
}