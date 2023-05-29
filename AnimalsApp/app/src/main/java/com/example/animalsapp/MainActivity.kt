package com.example.animalsapp

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.adapter.AnimalCardAdapter
import com.example.animalsapp.data.DataSource

import kotlin.math.log


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val data=DataSource
    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          recyclerView=findViewById(R.id.animalRecyclerView)
        recyclerView.layoutManager=GridLayoutManager(this,3)
        val image:ImageView=findViewById(R.id.animalImage)
        val myAdapter=AnimalCardAdapter(this,data,image)
        recyclerView.adapter=myAdapter
        }









}


