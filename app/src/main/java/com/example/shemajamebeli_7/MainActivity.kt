package com.example.shemajamebeli_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli_7.adapter.SideMenuRecyclerView
import com.example.shemajamebeli_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SideMenuRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SideMenuRecyclerView()
        with(binding){
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(root.context)
        }
    }
}