package com.example.mws.data.model

import com.squareup.moshi.Json

data class Episode(
	@Json(name = "air_date") val airDate: String?,
	@Json(name = "episode_number") val episodeNumber: Int?,
	val id: Int?,
	val name: String?,
	val overview: String?,
	@Json(name = "production_code") val productionCode: String?,
	@Json(name = "season_number") val seasonNumber: Int?,
	@Json(name = "still_path") val stillPath: String?,
	@Json(name = "vote_average") val voteAverage: Double?,
	@Json(name = "vote_count") val voteCount: Int?,
)