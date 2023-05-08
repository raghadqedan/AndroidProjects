package com.example.animalsapp.adapter

import android.content.Context
import android.graphics.Color.rgb
import android.media.MediaPlayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.animalsapp.R
import com.example.animalsapp.data.DataSource
import com.google.android.material.button.MaterialButton


class AnimalCardAdapter(
     var context:Context?,
     val data:DataSource

):BaseAdapter(){



    override fun getCount(): Int {
       return data.data.size
    }

    override fun getItem(position: Int): Any {
      return  data.data.get(position)
    }

    override fun getItemId(position: Int): Long {
         return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view=LayoutInflater.from(context ).inflate(R.layout.button_item,parent,false)
        var  b =view?.findViewById<MaterialButton>(R.id.button)
        b?.setText(data.data.get(position).name)
        if(position==0 || position%2==0){
            if (b != null) {
                b.setBackgroundColor(rgb(192, 127, 0))
            }
        }

        return view
    }


}


