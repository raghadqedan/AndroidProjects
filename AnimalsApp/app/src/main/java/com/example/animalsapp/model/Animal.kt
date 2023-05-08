package com.example.animalsapp.model

import androidx.annotation.DrawableRes

data class Animal(
 val name:String,
  val soundPath:Int,
   @DrawableRes val imagePath:Int
)
