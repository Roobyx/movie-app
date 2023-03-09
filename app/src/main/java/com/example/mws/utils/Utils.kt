package com.example.mws.utils

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mws.data.model.Movie
import com.example.mws.data.model.TVShow
import com.example.mws.databinding.MediaElementBinding
import java.time.LocalDate
import java.util.*

class MovieCardViewHolder(private val binding: MediaElementBinding) :
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
		val formattedVoteCount = "(${item.voteCount.toString()})"
		val posterImageView = binding.imageMediaPoster
//		TODO: Change with baseURL + API call for the size?
		val posterImageAddress = "https://image.tmdb.org/t/p/w154${item.posterPath}"

		binding.textMediaTitle.text = item.title
		binding.textReleaseDate.text = formattedDate
		binding.textRatingScore.text = formattedVoteCount

		Glide.with(posterImageView.context)
			.load(posterImageAddress)
			.into(posterImageView)

	}
}


class TVShowCardViewHolder(private val binding: MediaElementBinding) :
	RecyclerView.ViewHolder(binding.root) {

	private fun parseDayNumber(dayNumber: Int): String {
		return when (dayNumber) {
			1 -> "1st"
			2 -> "2nd"
			3 -> "3d"
			else -> "${dayNumber}th"
		}
	}

	fun bind(item: TVShow) {
		val releaseDate = LocalDate.parse(item.firstAirDate)
		val formattedMonthName = releaseDate.month.toString().lowercase()
			.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
		val formattedDate =
			"${parseDayNumber(releaseDate.dayOfMonth)} of $formattedMonthName ${releaseDate.year}"
		val formattedVoteCount = "(${item.voteCount.toString()})"
		val posterImageView = binding.imageMediaPoster
//		TODO: Change with baseURL + API call for the size?
		val posterImageAddress = "https://image.tmdb.org/t/p/w154${item.posterPath}"

		binding.textMediaTitle.text = item.name
		binding.textReleaseDate.text = formattedDate
		binding.textRatingScore.text = formattedVoteCount

		Glide.with(posterImageView.context)
			.load(posterImageAddress)
			.into(posterImageView)

	}
}