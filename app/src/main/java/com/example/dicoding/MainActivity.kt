package com.example.dicoding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.ListDemonAdapter
import com.example.dicoding.R
import com.example.dicoding.demonlisr

class MainActivity : AppCompatActivity() {
    private lateinit var rvDemon: RecyclerView
    private val list = ArrayList<demonlisr>()
    private var usingGrid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)
        rvDemon = findViewById(R.id.top10)
        rvDemon.setHasFixedSize(true)

        list.addAll(getListDemon())
        showRecyclerList()

    }

    private fun getListDemon(): ArrayList<demonlisr> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDemon = ArrayList<demonlisr>()
        for (i in dataName.indices) {
            val demon = demonlisr(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listDemon.add(demon)
        }
        return listDemon
    }

    private fun showRecyclerList() {
        rvDemon.layoutManager = LinearLayoutManager(this)
        val listDemonAdapter = ListDemonAdapter(list)
        rvDemon.adapter = listDemonAdapter

        listDemonAdapter.setOnItemClickCallback(object : ListDemonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: demonlisr) {
                showSelectedDemon(data)
            }
        })
    }

    private fun showSelectedDemon(demon: demonlisr) {
        Toast.makeText(this, "Kamu memilih " + demon.name, Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                usingGrid = !usingGrid
                if (usingGrid){
                    rvDemon.layoutManager = GridLayoutManager(this, 2)
                }else{
                    rvDemon.layoutManager = LinearLayoutManager(this)
                }

            }
            R.id.action_grid -> {
                val moveIntent = Intent(this@MainActivity, aboutme::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

