package com.example.mws.ui.view.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mws.R
import com.example.mws.data.model.Movie
import com.example.mws.databinding.MediaElementBinding
import com.example.mws.utils.MovieCardViewHolder

class MovieCardAdapter : RecyclerView.Adapter<MovieCardViewHolder>() {
	var data = listOf<Movie>()
		set(value) {
			field = value
//			TODO: Change
			notifyDataSetChanged()
		}

	override fun getItemCount(): Int = data.size

	override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) {
		val item = data[position]
		holder.bind(item)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val view = layoutInflater.inflate(R.layout.media_element, parent, false) as ConstraintLayout
		return MovieCardViewHolder(MediaElementBinding.bind(view))
	}

}

