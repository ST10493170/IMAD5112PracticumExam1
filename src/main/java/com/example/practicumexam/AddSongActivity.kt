package com.example.practicumexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AddSongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_song)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val titleView = findViewById<TextView>(R.id.titleView)
        val artistView = findViewById<TextView>(R.id.artistView)
        val ratingView = findViewById<TextView>(R.id.ratingView)
        val commentView = findViewById<TextView>(R.id.commentView)

        saveButton.setOnClickListener {
            val song = Song(
                titleView.text.toString(),
                artistView.text.toString(),
                ratingView.text.toString().toInt(),
                commentView.text.toString()
            )

            val resultIntent = Intent()
            resultIntent.putExtra("song", song)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}