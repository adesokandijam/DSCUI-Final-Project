package com.example.dscuifinal

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
    val image = itemView.findViewById<ImageView>(R.id.card_image)
    val name = itemView.findViewById<TextView>(R.id.card_name)
    val hours = itemView.findViewById<TextView>(R.id.card_detail)
}