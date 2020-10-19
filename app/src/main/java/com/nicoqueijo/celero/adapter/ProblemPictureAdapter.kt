package com.nicoqueijo.celero.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nicoqueijo.celero.R

class ProblemPictureAdapter(private val problemPictures: List<String>) :
    RecyclerView.Adapter<ProblemPictureAdapter.ProblemPictureViewHolder>() {

    inner class ProblemPictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val problemPicture: ImageView = itemView.findViewById(R.id.profile_picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemPictureViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.problem_picture, parent, false)
        return ProblemPictureViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProblemPictureViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(problemPictures[position])
            .into(holder.problemPicture)
    }

    override fun getItemCount() = problemPictures.size
}