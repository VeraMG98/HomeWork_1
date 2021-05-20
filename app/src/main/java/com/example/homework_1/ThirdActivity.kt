package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = NameAdapter(App.getList())
    }
}