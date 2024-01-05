package com.example.dicoding

import com.example.dicoding.databinding.DescriptionBinding
import android.app.Person
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class description : AppCompatActivity() {
    private lateinit var binding: DescriptionBinding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description)
        binding = DescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<demonlisr>("key_demon", demonlisr::class.java)

        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>("key_demon")

        }
        if (dataDemon != null) {
            binding.tvDetailName.text = dataDemon.name
            binding.tvDetailDescription.text = dataDemon.description
            binding.imgDetailPhoto.setImageResource(dataDemon.photo)
        }

    }

}


