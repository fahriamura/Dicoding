package com.example.dicoding

import android.os.Parcelable
import android.service.autofill.FillEventHistory
import kotlinx.parcelize.Parcelize

@Parcelize

data class statistic(
    val demonName:String,
    val creator: String,
    val verifier: String,
    val victor: String,
    val hstr : String,
): Parcelable
