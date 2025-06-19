package com.example.practicumexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var songList: MutableList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songList = mutableListOf(
                Song("Marvins Room", "Drake", 5, "Love"),
        Song("To My Lowest", "NBA Youngboy", 4, "Rap"),
        Song("IRan", "Rod Wave", 3, "Memories"),
        Song("Teenage Fever", "Drake", 4, "Dance"),
        Song("Backdoor", "Lil Durk", 2, "Rap"),
        Song("Wait For You", "Future", 5, "Love")
        )

        val addButton = findViewById<Button>(R.id.addButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java)
            startActivityForResult(intent, 1)
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java)
            intent.putParcelableArrayListExtra("songs", ArrayList(songList))
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            data?.getParcelableExtra<Song>("song")?.let {
                songList.add(it)
            }
        }
    }
}