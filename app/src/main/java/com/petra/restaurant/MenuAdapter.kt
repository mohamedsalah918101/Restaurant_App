package com.petra.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val itemList: List<MenuItem>, private val onItemClick: (MenuItem) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemView.setOnClickListener {
                onItemClick(itemList[adapterPosition])
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent,false)
        )
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemName.text = currentItem.name
        holder.itemImage.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}