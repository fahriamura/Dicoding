package com.example.dicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDemonAdapter(private val listdemon: ArrayList<demonlisr>): RecyclerView.Adapter<ListDemonAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.demonlist, parent, false)
        return ListViewHolder(view)
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_list_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_list_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_list_description)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentDemon = listdemon[position]
        holder.tvName.text = currentDemon.name
        holder.tvDescription.text = currentDemon.description
        holder.imgPhoto.setImageResource(currentDemon.photo)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(currentDemon,position)
        }
    }

    override fun getItemCount(): Int {
        return listdemon.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: demonlisr,position: Int)
    }
}