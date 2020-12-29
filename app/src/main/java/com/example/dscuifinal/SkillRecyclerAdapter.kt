package com.example.dscuifinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.net.URL

@Suppress("DEPRECATION")
class SkillRecyclerAdapter(private val person: Array<com.example.dscuifinal.SkillPerson>) : RecyclerView.Adapter<SkillViewHolder>() {

   // val fetchJson = FetchJson()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_view_holder,parent,false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.name.text = person[position].name
        holder.hours.text = "${person[position].score} skill IQ score, ${person[position].country}"
        val url: URL = URL(person[position].badgeUrl)
        Glide.with(holder.image.context).load(url).into(holder.image)
    }
    override fun getItemCount() = person.size

}
