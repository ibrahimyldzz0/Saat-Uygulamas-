package com.example.saatapp



import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var clockTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockTextView = findViewById(R.id.clockTextView)

        // Saati güncelleyen metodu her saniyede bir çağır
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                updateClock()
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun updateClock() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"))
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("Europe/Istanbul")
        val currentTime = dateFormat.format(calendar.time)
        clockTextView.text = currentTime
    }
}