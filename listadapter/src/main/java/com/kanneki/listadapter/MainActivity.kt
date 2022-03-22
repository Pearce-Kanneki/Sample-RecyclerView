package com.kanneki.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanneki.listadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = myAdapter
        }

        myAdapter.submitList(Repository.createFakeList(20))
    }
}