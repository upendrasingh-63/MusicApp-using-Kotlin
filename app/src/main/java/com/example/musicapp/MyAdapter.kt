package com.example.musicapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//adapter the connect the use interface with data source
class MyAdapter(val context: Activity, val  dataList: List<Data>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create the view in case the layout fails to create view for the data
        var itemView=LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //populate data into the view
        var currentView=dataList[position]

        var mediaplayer=MediaPlayer.create(context,currentView.preview.toUri())
        holder.Title.text=currentView.title
        Picasso.get().load(currentView.album.cover).into(holder.Image);

        holder.Playbtn.setOnClickListener{
            mediaplayer.start()
        }
        holder.Pausebtn.setOnClickListener{
            mediaplayer.stop()
        }
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val Image:ImageView
        val Title:TextView
        val Playbtn:ImageButton
        val Pausebtn:ImageButton

        init {
            Image=itemView.findViewById(R.id.musicImg)
            Title=itemView.findViewById(R.id.musicTitle)
            Playbtn=itemView.findViewById(R.id.btnPlay)
            Pausebtn=itemView.findViewById(R.id.btnPause)
        }
    }

}