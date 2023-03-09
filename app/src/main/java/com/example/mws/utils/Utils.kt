package com.example.mws.utils

import androidx.recyclerview.widget.RecyclerView
import com.example.mws.data.model.Movie
import com.example.mws.databinding.MediaElementBinding
import java.time.LocalDate
import java.util.*

class MediaItemViewHolder(private val binding: MediaElementBinding) :
	RecyclerView.ViewHolder(binding.root) {

	private fun parseDayNumber(dayNumber: Int): String {
		return when (dayNumber) {
			1 -> "1st"
			2 -> "2nd"
			3 -> "3d"
			else -> "${dayNumber}th"
		}
	}


	fun bind(item: Movie) {
		val releaseDate = LocalDate.parse(item.releaseDate)
		val formattedMonthName = releaseDate.month.toString().lowercase()
			.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
		val formattedDate =
			"${parseDayNumber(releaseDate.dayOfMonth)} of $formattedMonthName ${releaseDate.year}"
		val formattedVoteCount = item.voteCount.toString()

		binding.textMediaTitle.text = item.title
//		binding.imageMediaPoster.
		binding.textReleaseDate.text = formattedDate
		binding.textRatingScore.text = formattedVoteCount
	}
}