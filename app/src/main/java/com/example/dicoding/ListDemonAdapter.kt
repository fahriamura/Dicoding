package com.example.dicoding

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDemonAdapter(private val listdemon: ArrayList<demonlisr>){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_detail_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_detail_description)
    }

    fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listdemon[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intentDetail = Intent(holder.itemView.context, description::class.java)
            intentDetail.putExtra("key_demon", listdemon[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
            context.startActivity(intentDetail)
        }



    }

    interface OnItemClickCallback {
        fun onItemClicked(data: demonlisr)
    }
}
