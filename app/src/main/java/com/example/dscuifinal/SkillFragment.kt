package com.example.dscuifinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException


class SkillFragment : Fragment() {

    lateinit var skillRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skill,container,false)
        skillRecyclerView = view.findViewById(R.id.skillRecyclerView)
        skillRecyclerView.layoutManager = LinearLayoutManager(context)
        fetchJson()
        return view
    }
    private fun fetchJson() {
        val url = "https://gadsapi.herokuapp.com/api/skilliq"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val person = gson.fromJson(body, Array<com.example.dscuifinal.SkillPerson>::class.java)
                activity?.runOnUiThread {
                    skillRecyclerView.adapter = SkillRecyclerAdapter(person)
                }
            }
        })
    }

}

class SkillPerson (val name: String, val score: String, val country:String, val badgeUrl: String)