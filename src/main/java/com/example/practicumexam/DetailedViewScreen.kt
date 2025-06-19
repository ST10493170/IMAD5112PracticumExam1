package com.example.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedViewActivity : AppCompatActivity() {

    private lateinit var songs: ArrayList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        songs = intent.getParcelableArrayListExtra("songs") ?: arrayListOf()

        val outputText = findViewById<TextView>(R.id.outputText)
        val listButton = findViewById<Button>(R.id.listButton)
        val averageButton = findViewById<Button>(R.id.averageButton)
        val backButton = findViewById<Button>(R.id.backButton)

        listButton.setOnClickListener {
            val result = StringBuilder()
            for (song in songs) {
                result.append("Title: ${song.title}\nArtist: ${song.artist}\nRating: ${song.rating}\nComment: ${song.comment}\n\n")
            }
            outputText.text = result.toString()
        }

        averageButton.setOnClickListener {
            var total = 0
            for (song in songs) {
                total += song.rating
            }
            val avg = if (songs.isNotEmpty()) total.toDouble() / songs.size else 0.0
            outputText.text = "Average Rating: %.2f".format(avg)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}