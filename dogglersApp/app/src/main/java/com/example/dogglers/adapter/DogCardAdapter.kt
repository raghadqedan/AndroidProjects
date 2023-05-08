/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.model.Dog
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout:Int ,

): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val data=DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogImage=view?.findViewById<ImageView>(R.id.dogImage)
        val dogName=view?.findViewById<TextView>(R.id.dogName)
        val dogAge=view?.findViewById<TextView>(R.id.dogAge)
        val dogHobbies=view?.findViewById<TextView>(R.id.dogHobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        if(layout==3){
        val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
        return DogCardAdapter.DogCardViewHolder(adapterLayout)}
        else
        {     val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
            return DogCardAdapter.DogCardViewHolder(adapterLayout)}}


        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.



    override fun getItemCount():Int{
        return data.dogs.size
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item=data.dogs[position]
        holder.dogImage?.setBackgroundResource(item.imageResourceId)
        holder.dogName?.text=item.name
        holder.dogAge?.append(item.age)
       holder.dogHobbies?.append(item.hobbies)
    }
}
