package com.example.dicoding

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.databinding.DescriptionBinding

class description : AppCompatActivity() {
    private lateinit var binding: DescriptionBinding

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHero: demonlisr? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_demon")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_demon")
        }


        dataHero?.let {
            binding.tvDetailName.text = it.name
            binding.tvDetailDescription.text = it.description
            binding.imgDetailPhoto.setImageResource(it.photo)
        }


        val positionClicked: Int = intent.getIntExtra("position_clicked", -1)
        val authorList: ArrayList<statistic>? = intent.getSerializableExtra("array") as? ArrayList<statistic>


        if (authorList != null && positionClicked != -1 && positionClicked < authorList.size) {
            val selectedAuthor = authorList[positionClicked]


            binding.crt.text = selectedAuthor.creator
            binding.ver.text = selectedAuthor.verifier
            binding.vct.text = selectedAuthor.victor
            binding.hs.text=selectedAuthor.hstr
        }
    }
}



