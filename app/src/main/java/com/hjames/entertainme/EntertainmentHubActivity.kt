package com.hjames.entertainme

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.hjames.entertainme.adapters.EntertainmentAdapter
import com.hjames.entertainme.controllers.EntertainmentHubActivityController
import co.metalab.asyncawait.async

class EntertainmentHubActivity : AppCompatActivity() {
    private var tag = this.javaClass.name
    private lateinit var controller: EntertainmentHubActivityController
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entertainment_hub)

        controller = EntertainmentHubActivityController()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = EntertainmentAdapter(getAnimeListAsync().toTypedArray())

        recyclerView = findViewById<RecyclerView>(R.id.anime_recycler_view).apply {
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    private fun getAnimeListAsync(): List<String> {
        val animeList = mutableListOf<String>()

        async {
            try {
                val result = await { controller.getAnimeList() }
            } catch (ex: Exception) {
                Log.e(tag, "ERROR -> " + ex.message)
            }
        }.onError {
            Log.e(tag, "An error occurred while trying to call the requested API!")
        }

        return animeList
    }
}