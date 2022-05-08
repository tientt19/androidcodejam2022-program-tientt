package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.adapter.ItemAdapter
import com.example.recycleview.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = DataSource().loadAffirmations()
        val recycleView = findViewById<RecyclerView>(R.id.recycle_view)
        recycleView.adapter = ItemAdapter(this,myDataset)
        recycleView.setHasFixedSize(true)
    }
}