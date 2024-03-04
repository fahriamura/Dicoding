package com.example.dicoding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.R
import com.example.dicoding.demonlisr
import java.text.FieldPosition

class demon : AppCompatActivity() {

    private lateinit var rvDemon: RecyclerView
    private val list = ArrayList<demonlisr>()
    private var usingGrid = false
    private val authorlist = ArrayList<statistic>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        rvDemon = findViewById(R.id.top10)
        rvDemon.setHasFixedSize(true)

        list.addAll(getListDemon())
        authorlist.addAll(getListAuthor())
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
    private fun getListAuthor(): ArrayList<statistic> {
        val dataName = resources.getStringArray((R.array.demonName))
        val dataCreators = resources.getStringArray(R.array.creators)
        val dataVerifier = resources.getStringArray(R.array.verifier)
        val dataVictors = resources.getStringArray(R.array.victors)
        val dataHistory = resources.getStringArray(R.array.history)
        val listAuthor = ArrayList<statistic>()
        for (i in dataName.indices) {
            val authors = statistic(dataName[i],dataCreators[i], dataVerifier[i], dataVictors[i],dataHistory[i])
            listAuthor.add(authors)
        }
        return listAuthor
    }

    private fun showRecyclerList() {
        rvDemon.layoutManager = LinearLayoutManager(this)
        val listDemonAdapter = ListDemonAdapter(list)
        rvDemon.adapter = listDemonAdapter

        listDemonAdapter.setOnItemClickCallback(object : ListDemonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: demonlisr,position: Int) {
                val intentToDetail = Intent(this@demon, description::class.java)
                val positionClicked: Int = intent.getIntExtra("position_clicked", -1)
                intentToDetail.putExtra("key_demon", data)
                intentToDetail.putExtra("position_clicked", position)
                intentToDetail.putExtra("array", authorlist)
                startActivity(intentToDetail)




            }

        })
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
                val moveIntent = Intent(this@demon, aboutme::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}



