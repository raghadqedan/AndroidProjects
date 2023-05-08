package com.example.animalsapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.animalsapp.adapter.AnimalCardAdapter
import com.example.animalsapp.data.DataSource
import kotlin.math.log


class MainActivity : AppCompatActivity() , AdapterView.OnItemClickListener{
    lateinit var gridView: GridView
    val data=DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          gridView=findViewById(R.id.animalGridLayout)
        val myAdapter=AnimalCardAdapter(this,data)
        gridView.adapter=myAdapter
        gridView.setOnItemClickListener(this)


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val image=findViewById<ImageView>(R.id.animalImage)
        val item = data.data[position]
        image.setBackgroundResource(item.imagePath)
        val mediaPlayer = MediaPlayer.create( this, R.raw.assets_audios_cat)
        mediaPlayer.start()
    }
}