package com.example.animalsapp.data

import com.example.animalsapp.R
import com.example.animalsapp.model.Animal


object DataSource {
    val data:List<Animal> = listOf(
        Animal("Cat", R.raw.assets_audios_cat,R.drawable.cat),
        Animal("Cheetah", R.raw.cheetah5,R.drawable.cheetah),
        Animal("Crocodile", R.raw.assets_audios_crocodile,R.drawable.crocodile),
        Animal("Dog", R.raw.assets_audios_dog, R.drawable.dog),
        Animal("Elephant", R.raw.assets_audios_elephant,R.drawable.elephant),
        Animal("Giraffe", R.raw.assets_audios_giraffe,R.drawable.giraffe),
        Animal("Lion", R.raw.lion,R.drawable.lion),
        Animal("Parrot", R.raw.assets_audios_parrot,R.drawable.parrot),
        Animal("Wolf", R.raw.assets_audios_wolf,R.drawable.wolf)




    )
}