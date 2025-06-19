package com.example.practicumexam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val title: String,
    val artist: String,
    val rating: Int,
    val comment: String
) : Parcelable


