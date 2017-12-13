package com.viktordolgalyov.populartracks.component.trending.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.viktordolgalyov.populartracks.R
import com.viktordolgalyov.populartracks.component.trending.data.Track
import kotlinx.android.synthetic.main.item_track.view.*

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackHolder>() {
    private val items = mutableListOf<Track>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrackHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_track, parent, false)
        return TrackHolder(itemView)
    }

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        val track = items[position]
        val duration = String.format("%d:%02d", track.duration / 60, track.duration % 60)
        holder.itemView.title.text = track.title
        holder.itemView.subtitle.text = String.format("%s \u00B7 %s", track.artist, duration)
        Glide.with(holder.itemView).load(track.image).into(holder.itemView.icon)
    }

    fun addData(data: List<Track>) {
        val prevSize = itemCount
        items.addAll(data)
        notifyItemRangeInserted(prevSize, data.size)
    }

    override fun getItemCount() = items.size

    class TrackHolder(view: View) : RecyclerView.ViewHolder(view)
}