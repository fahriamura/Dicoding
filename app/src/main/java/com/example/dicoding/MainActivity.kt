package com.example.dicoding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.ListDemonAdapter
import com.example.dicoding.R
import com.example.dicoding.demonlisr
import java.text.FieldPosition

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.dicoding.Splashy


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        setSplashy()
    }

    private fun setSplashy() {
        Splashy(this)
            .setLogo(R.drawable.gg)
            .setAnimation(Splashy.Animation.GROW_LOGO_FROM_CENTER)
            .setBackgroundResource(R.drawable.gd)
            .setTitle("Geometry Dash Demon List")
            .setTitleColor(R.color.white)
            .setTitleSize(40F)
            .setProgressColor(R.color.white)
            .setFullScreen(true)
            .setDuration(5000)
            .show()

        Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
                val intentToDemon = Intent(this@MainActivity, demon::class.java)
                startActivity(intentToDemon)
                finish() // Optional: finish the current activity if needed
            }
        })
    }

    public fun showSplash(v: View) {
        setSplashy()
        // Hides after 1sec
        Handler().postDelayed({
            Splashy.hide()
        }, 1000)
    }

}

