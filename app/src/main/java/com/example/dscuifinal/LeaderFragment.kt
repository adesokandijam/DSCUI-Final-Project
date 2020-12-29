package com.example.dscuifinal

import android.app.Person
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

class LeaderFragment : Fragment() {


    lateinit var leaderRecyclerView: RecyclerView
    var person1 : Array<Person> ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_leader,container,false)
        leaderRecyclerView = view.findViewById(R.id.leaderRecyclerView)
        leaderRecyclerView.layoutManager = LinearLayoutManager(context)

        fetchJson()
        return view
    }
    private fun fetchJson()
    {
        val url = "https://gadsapi.herokuapp.com/api/hours"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
            client.newCall(request).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body?.string()
                    val gson = GsonBuilder().create()
                    val person = gson.fromJson(body, Array<com.example.dscuifinal.Person>::class.java)
                    activity?.runOnUiThread{
                        leaderRecyclerView.adapter = LeaderRecyclerAdapter(person)
                    }
                    //person1 = person

                }
            })


    }






}