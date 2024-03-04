package com.example.dicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class demonlisr(
    val name: String,
    val description: String,
    val photo: Int,

): Parcelable
