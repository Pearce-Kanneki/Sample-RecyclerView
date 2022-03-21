package com.kanneki.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanneki.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = arrayListOf<ExpandableAdapter>()
        val groupedItemList = Repository.createGroupedItemList(20)

        groupedItemList.forEach { groupItem ->
            val adapter = ExpandableAdapter(groupItem)
            list.add(adapter)
        }

        val concatAdapterConfig = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()

        val concatAdapter = ConcatAdapter(concatAdapterConfig, list)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = concatAdapter
        }
    }
}