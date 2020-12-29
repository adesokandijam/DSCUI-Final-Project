package com.example.dscuifinal

import android.app.Person
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.net.URL

@Suppress("DEPRECATION")
class LeaderRecyclerAdapter(private val person: Array<com.example.dscuifinal.Person>): RecyclerView.Adapter<SkillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_view_holder,parent,false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.name.text = person[position].name
        holder.hours.text = "${person[position].hours} learning hours, ${person[position].country}"
        val url:URL = URL(person[position].badgeUrl)
        Glide.with(holder.image.context).load(url).into(holder.image)
    }

    override fun getItemCount() = person.size

}
