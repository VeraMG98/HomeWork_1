package com.example.homework_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(private val names: List<String>) :
    RecyclerView.Adapter<NameAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName : TextView? = null

        init {
            txtName = itemView.findViewById(R.id.names)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_name, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtName?.text = names[position]
    }
}