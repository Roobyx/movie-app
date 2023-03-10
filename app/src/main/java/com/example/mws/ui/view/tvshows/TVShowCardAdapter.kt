package com.example.mws.ui.view.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mws.R
import com.example.mws.data.model.TVShow
import com.example.mws.databinding.MediaElementBinding
import com.example.mws.utils.TVShowCardViewHolder

//TODO: There must be a way to join the 2 adapters
class TVShowCardAdapter : RecyclerView.Adapter<TVShowCardViewHolder>() {
	var data = listOf<TVShow>()
		set(value) {
			field = value
//			TODO: Change
			notifyDataSetChanged()
		}

	override fun getItemCount(): Int = data.size

	override fun onBindViewHolder(holder: TVShowCardViewHolder, position: Int) {
		val item = data[position]
		holder.bind(item)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowCardViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val view = layoutInflater.inflate(R.layout.media_element, parent, false) as ConstraintLayout
		return TVShowCardViewHolder(MediaElementBinding.bind(view))
	}

}

