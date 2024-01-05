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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.description)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<demonlisr>("key_demon", demonlisr::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<demonlisr>("key_demon")
        }

        binding.tvDetailName.text = dataHero?.name!!
        binding.tvDetailDescription.text = dataHero.description
        binding.imgDetailPhoto.setImageResource(dataHero.photo)
    }
}



