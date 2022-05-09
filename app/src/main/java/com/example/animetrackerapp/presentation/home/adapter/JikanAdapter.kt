package com.example.animetrackerapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animetrackerapp.R
import com.example.animetrackerapp.domain.model.TopAnime
import com.squareup.picasso.Picasso

//todo add on item click to see the detail of anime chosen
class JikanAdapter(private var animeList: List<TopAnime>) :
    RecyclerView.Adapter<JikanAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val score: TextView = view.findViewById(R.id.score)
        val imageUrl: ImageView = view.findViewById(R.id.imageUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        holder.title.text = anime.title
        holder.score.text = anime.score.toString()
        Picasso.get().load(anime.imageUrl).into(holder.imageUrl);
    }

    override fun getItemCount(): Int = animeList.size

    fun updateAnimeList(animeList: List<TopAnime>) {
        this.animeList = animeList
        notifyDataSetChanged()
    }
}