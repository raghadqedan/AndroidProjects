package com.example.animalsapp.adapter

import android.content.Context
import android.graphics.Color.rgb
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.R
import com.example.animalsapp.data.DataSource
import com.google.android.material.button.MaterialButton


class AnimalCardAdapter(
     var context:Context,
     val data:DataSource,
     private val animalsImage:ImageView

):RecyclerView.Adapter<AnimalCardAdapter.AnimalViewHolder>() {
    var mediaPlayer: MediaPlayer? = null
    private var timer: CountDownTimer? = null

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var button = view.findViewById<MaterialButton>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.button_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        holder.button.setText(data.data.get(position).name)
        if (position == 0 || position % 2 == 0) {
            if (holder.button != null) {
                holder.button.setBackgroundColor(rgb(192, 127, 0))
            }
        }
           holder.button.setOnClickListener {
            val item = data.data[position]
            animalsImage?.setImageResource(item.imagePath)
            //to prevent the animals sound overlapping
            mediaPlayer?.release()
            mediaPlayer = null
            timer?.cancel()

            // Create a new CountDownTimer with a delay of 1 second
            timer = object : CountDownTimer(1000, 100000) {
                override fun onTick(millisUntilFinished: Long) {
                    // Not used
                }
                override fun onFinish() {
                    // Create and start a new MediaPlayer instance
                    mediaPlayer = MediaPlayer.create(context, item.soundPath)
                    mediaPlayer?.start()
                }
            }
            // Start the timer
            timer?.start()
            val mediaPlayer = MediaPlayer.create(context, item.soundPath)
            mediaPlayer.start()
        }
    }
    override fun onViewRecycled(holder: AnimalViewHolder) {
        super.onViewRecycled(holder)
        // Release MediaPlayer instance when the view is recycled
        mediaPlayer?.release()

        // Cancel the timer if running
        timer?.cancel()
    }

    override fun getItemCount(): Int {
        return data.data.size
    }
}






